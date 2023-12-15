package com.vikadata.social.wecom;

import java.time.Duration;
import java.util.Map;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import me.chanjar.weixin.common.redis.RedisTemplateWxRedisOps;
import me.chanjar.weixin.common.redis.WxRedisOps;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.config.impl.WxCpDefaultConfigImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vikadata.social.wecom.config.WeComRedisConfigImpl;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * WeCom template operation abstract class
 */
public abstract class AbstractWeComTemplate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractWeComTemplate.class);

    private final static String CONFIG_KEY = "work_weixin:config:";

    private final static String TEMP_CONFIG_KEY = "work_weixin:temp_config:";

    private final StringRedisTemplate stringRedisTemplate;

    private final RestTemplate restTemplate;

    protected WeComConfig weComConfig;

    // key：corpId + agentId
    protected static Map<String, WxCpService> cpServices = Maps.newConcurrentMap();

    // key：corpId + agentId , cache temporarily authorized services, the default timeout is 2 hours
    protected static TimedCache<String, WxCpService> cpServicesByTempAuth =
        CacheUtil.newTimedCache(Duration.ofHours(2).toMillis());

    public AbstractWeComTemplate(WeComConfig weComConfig, StringRedisTemplate stringRedisTemplate) {
        this.weComConfig = weComConfig;
        this.stringRedisTemplate = stringRedisTemplate;
        this.restTemplate = createRestTemplate();
    }

    /**
     * Abstract Service that opens API
     *
     * @return WxCpService
     */
    public abstract WxCpService openService();

    /**
     * Abstract Service that closes the API
     */
    public abstract void closeService();

    /**
     * Get the basic public configuration of WeCom
     *
     * @return WeComConfig
     */
    public WeComConfig getConfig() {
        return weComConfig;
    }

    /**
     * merge key
     *
     * @param corpId  corp id
     * @param agentId agent id
     * @return key
     */
    public String mergeKey(String corpId, Integer agentId) {
        return String.format("%s-%s", corpId, agentId);
    }

    /**
     * Get cache configuration file prefix
     *
     * @return cache configuration file prefix
     */
    public String getCacheConfigKeyPrefix() {
        return getCacheConfigKeyPrefix(false);
    }

    /**
     * Get cache configuration file prefix
     *
     * @param isTemp Is temporary
     * @return cache configuration file prefix
     */
    public String getCacheConfigKeyPrefix(boolean isTemp) {
        String prefix = StrUtil.isBlank(weComConfig.getKeyPrefix()) ? "" :
            StrUtil.appendIfMissing(weComConfig.getKeyPrefix(), ":");
        return prefix + (isTemp ? TEMP_CONFIG_KEY : CONFIG_KEY);
    }

    /**
     * Query whether the current cache service
     * Unable to query temporary authorization service
     *
     * @param key cache key
     * @return true: exist false: not exist
     */
    public boolean isExistService(String key) {
        return isExistService(key, false);
    }

    /**
     * Query whether the current cache service
     *
     * @param key               cache key
     * @param isTempAuthService Query temporary services
     * @return true: exist false: not exist
     */
    public boolean isExistService(String key, boolean isTempAuthService) {
        if (isTempAuthService) {
            return cpServicesByTempAuth.containsKey(key);
        }
        return cpServices.containsKey(key);
    }

    /**
     * Dynamically add enterprise WeCom service class
     *
     * @param corpId      corp Id
     * @param agentId     agent id
     * @param agentSecret agent secret key
     * @return WxCpService
     */
    public WxCpService addService(String corpId, Integer agentId, String agentSecret) {
        return addService(corpId, agentId, agentSecret, false, -1);
    }

    /**
     * Dynamically add enterprise WeCom service class
     *
     * @param corpId            corp id
     * @param agentId           agent id
     * @param agentSecret       agent secret key
     * @param isTempAuthService Is it temporarily authorized
     * @param timeout           Temporary authorization timeout
     * @return WxCpService
     */
    public WxCpService addService(String corpId, Integer agentId, String agentSecret,
                                  boolean isTempAuthService, long timeout) {
        WxCpService service;
        String key = this.mergeKey(corpId, agentId);
        if (!isTempAuthService) {
            switch (weComConfig.getStorageType()) {
                case "memory": {
                    service = this.memoryBulid(corpId, agentId, agentSecret);
                    break;
                }
                case "redis": {
                    service = this.redisBulid(corpId, agentId, agentSecret);
                    break;
                }
                default:
                    throw new IllegalStateException(
                        "Construct enterprise WeCom service[" + weComConfig.getStorageType() +
                            "] policy does not exist.");
            }
            cpServices.put(key, service);
        } else {
            // The temporary authorization service cannot use Redis mode and automatically switches to in-memory build mode
            service = this.memoryBulid(corpId, agentId, agentSecret);
            cpServicesByTempAuth.put(key, service, timeout);
            return service;
        }
        return service;
    }

    /**
     * Build Services in Memory
     */
    private WxCpService memoryBulid(String corpId, Integer agentId, String agentSecret) {
        WxCpService service = new WxCpServiceImpl();
        WxCpDefaultConfigImpl configStorage = new WxCpDefaultConfigImpl();
        configStorage.setCorpId(corpId);
        configStorage.setAgentId(agentId);
        configStorage.setCorpSecret(agentSecret);
        service.setWxCpConfigStorage(configStorage);
        // Since no callback service is configured, ticket and aesKey are not instantiated here
        return service;
    }

    /**
     * Use Redis to build Service.
     *
     * @param corpId      corp id
     * @param agentId     agent id
     * @param agentSecret agent secret key
     * @return WxCpService
     */
    private WxCpService redisBulid(String corpId, Integer agentId, String agentSecret) {
        WxCpService service = new WxCpServiceImpl();
        if (null == stringRedisTemplate) {
            throw new RuntimeException(
                "Construction failed: Currently unable to get Redis connection, you can try to "
                    + "use: Memory mode.");
        }
        WxRedisOps redisOps = new RedisTemplateWxRedisOps(stringRedisTemplate);

        WeComRedisConfigImpl configStorage =
            new WeComRedisConfigImpl(redisOps, weComConfig.getKeyPrefix());
        configStorage.setCorpId(corpId);
        configStorage.setAgentId(agentId);
        configStorage.setCorpSecret(agentSecret);
        service.setWxCpConfigStorage(configStorage);
        return service;
    }

    /**
     * Remove temporary authorization service
     *
     * @param key key
     */
    public void removeCpServicesByTempAuth(String key) {
        cpServicesByTempAuth.remove(key);
    }

    /**
     * create RestTemplate
     */
    private RestTemplate createRestTemplate() {
        RestTemplate client = new RestTemplate();
        client.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return client;
    }

    /**
     * get RestTemplate.
     *
     * @return RestTemplate
     */
    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
