package com.vikadata.social.core;

import java.util.concurrent.locks.Lock;

/**
 * configuring storage interfaces
 */
public interface ConfigStorage {

    /**
     * get app id
     * @return app id
     */
    String getAppId();

    /**
     * get app secret
     * @return app secret
     */
    String getAppSecret();

    /**
     * whether is isv
     * @return token
     */
    boolean isv();

    /**
     * get user access token lock
     * @param userAuth user auth
     * @return token
     */
    Lock getUserAccessTokenLock(String userAuth);

    /**
     * get app access token lock
     * @return token
     */
    Lock getAppAccessTokenLock();

    /**
     * get tenant access token lock
     * @param tenantKey tenant key
     * @return token
     */
    Lock getTenantAccessTokenLock(String tenantKey);

    /**
     * get user access token
     * @param accessToken access token
     * @return token
     */
    String getUserAccessToken(String accessToken);

    /**
     * whether user access token is expired
     * @param accessToken access token
     * @return token
     */
    boolean isUserAccessTokenExpired(String accessToken);

    /**
     * expire user access token
     * @param accessToken access token
     */
    void expireUserAccessToken(String accessToken);

    /**
     * update user access token
     * @param accessToken access token
     * @param userAccessToken user access token
     * @param expiresInSeconds expires in seconds
     */
    void updateUserAccessToken(String accessToken, String userAccessToken, int expiresInSeconds);

    /**
     * get app access token
     * @return token
     */
    String getAppAccessToken();

    /**
     * update app access token
     * @param appAccessToken app access token
     * @param expiresInSeconds expires in seconds
     */
    void updateAppAccessToken(String appAccessToken, int expiresInSeconds);

    /**
     * whether app access token is expired
     * @return token
     */
    boolean isAppAccessTokenExpired();

    /**
     * expire app access token
     */
    void expireAppAccessToken();

    /**
     * get tenant access token
     * @param tenantKey tenant key
     * @return token
     */
    String getTenantAccessToken(String tenantKey);

    /**
     * update tenant access token
     * @param tenantKey tenant key
     * @param tenantAccessToken tenant access token
     * @param expiresInSeconds expires in seconds
     */
    void updateTenantAccessToken(String tenantKey, String tenantAccessToken, int expiresInSeconds);

    /**
     * whether tenant access token is expired
     * @param tenantKey tenant key
     * @return token
     */
    boolean isTenantAccessTokenExpired(String tenantKey);

    /**
     * expire tenant access token
     * @param tenantKey tenant key
     */
    void expireTenantAccessToken(String tenantKey);
}
