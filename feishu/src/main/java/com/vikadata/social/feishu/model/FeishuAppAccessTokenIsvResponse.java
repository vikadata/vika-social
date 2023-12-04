package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * feishu app access token isv response.
 * </p>
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuAppAccessTokenIsvResponse extends BaseResponse {

    private String appAccessToken;

    private int expire;
}
