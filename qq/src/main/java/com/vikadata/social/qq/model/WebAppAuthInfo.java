package com.vikadata.social.qq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * QQ web app auth info
 */
@Data
public class WebAppAuthInfo {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("unionid")
    private String unionId;
}
