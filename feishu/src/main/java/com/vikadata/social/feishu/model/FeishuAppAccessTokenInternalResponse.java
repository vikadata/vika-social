package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * feishu app access token internal response.
 * </p>
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuAppAccessTokenInternalResponse extends BaseResponse {

    private String appAccessToken;

    private int expire;
}
