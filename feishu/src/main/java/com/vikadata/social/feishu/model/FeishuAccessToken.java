package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Feishu Access Token Object.
 *
 * @author Shawn Deng
 */
@Setter
@Getter
public class FeishuAccessToken {

    private String accessToken;

    private String avatarUrl;

    private String avatarThumb;

    private String avatarMiddle;

    private String avatarBig;

    private int expiresIn;

    private String name;

    private String enName;

    private String openId;

    private String tenantKey;

    private String unionId;

    private int refreshExpiresIn;

    private String refreshToken;

    private String tokenType;

    // The following are only available for self-built applications
    private String email;

    private String userId;

    private String mobile;
}
