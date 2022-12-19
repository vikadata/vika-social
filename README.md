# Vika Social SDK (vika-social)<br/>Specially used for domestic [_vika SaaS_](https://vika.cn) application

![action](https://github.com/vikadata/vika-social/actions/workflows/test.yml/badge.svg)
![action](https://github.com/vikadata/vika-social/actions/workflows/build.yml/badge.svg)
[![MIT](https://img.shields.io/badge/licenses-MIT-orange)](https://vikadata.mit-license.org/)
[![Maven Central](https://img.shields.io/maven-central/v/cn.vika/vika-social.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22cn.vika%22%20AND%20a:%22vika-social%22)

## Usage

### Java Version Requirement

Java 8+ is required to use sdk. not support Java 8 below

## Getting Started

### Installation

* For a Maven project, add the following to your `pom.xml` file:

```xml
<dependency>
    <groupId>cn.vika</groupId>
    <artifactId>vika-social</artifactId>
    <version>1.0.1</version>
</dependency>
```

* For a Gradle project, add the following to your `build.gradle` file:

```groovy
dependencies {
  ...
  implementation('cn.vika:vika-social:1.0.1')
}
```

## **Usage Example**
vika socail sdk provide multiple corp app operations include FeiShu、DingTalk、QQ and WeCom.  
Just need to import the correspond packages to use.

#### **DingTalk**

Create register and delete call back url methods.

```java
import com.vikadata.social.dingtalk.DingTalkTemplate;

@Autowired
private DingTalkTemplate dingTalkTemplate;

@Override
public void registerCallbackUrl(String agentId, String url, List<String> events) {
        try {
            dingTalkTemplate.serviceCorpAppOperations().registerCallbackUrl(agentId, url, events);
        }
        catch (Exception e) {
            log.error("DingTalk failed to register callback address:{}", url, e);
        }
    }

@Override
public void deleteCallbackUrl(String agentId) {
        try {
            dingTalkTemplate.serviceCorpAppOperations().deleteCallbackUrl(agentId);
        }
        catch (Exception e) {
            log.error("DingTalk failed to delete callback address:{}", agentId, e);
        }
    }
```

#### **FeiShu**

Get FeiShu tenant information by FeiShu service provider.

```java
import com.vikadata.social.feishu.FeishuServiceProvider;

@Autowired
private FeishuServiceProvider feishuServiceProvider;

@Override
public FeishuTenantInfo getFeishuTenantInfo(String tenantKey) {
    return feishuServiceProvider.getFeishuTemplate().tenantOperations().getTenantInfo(tenantKey).getData().getTenant();
}
```

#### **QQ**

Get QQ authorization token information.

```java
import com.vikadata.social.qq.QQTemplate;

@Autowired
private QQTemplate qqTemplate;

@Override
public AccessTokenInfo getAccessToken(String code) {
    return AccessTokenInfo tokenInfo = qqTemplate.authOperations().getAccessToken(code);
}

```

#### **WeCom**

Quote WeCom authorization cache entity class.

```java
import com.vikadata.social.wecom.model.WeComAuthInfo;

public ResponseData<Void> weComBindConfig(@PathVariable("configSha") String configSha, @RequestBody @Valid WeComAgentBindSpaceRo body){
    ...
    // Check whether the binding information is valid
    WeComAuthInfo agentConfig=iWeComService.getConfigSha(configSha);
    ExceptionUtil.isNotNull(agentConfig,TENANT_APP_BIND_INFO_NOT_EXISTS);
}
```

## License
Open Source software released under the [MIT License](https://vikadata.mit-license.org).