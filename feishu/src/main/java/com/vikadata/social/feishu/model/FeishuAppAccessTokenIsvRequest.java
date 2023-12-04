package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * feishu app access token isv request.
 * </p>
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuAppAccessTokenIsvRequest {

    private String appId;

    private String appSecret;

    private String appTicket;
}
