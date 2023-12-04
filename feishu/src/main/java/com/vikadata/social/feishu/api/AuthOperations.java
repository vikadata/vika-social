package com.vikadata.social.feishu.api;

import com.vikadata.social.feishu.exception.FeishuApiException;
import com.vikadata.social.feishu.model.FeishuAccessToken;
import com.vikadata.social.feishu.model.FeishuUserAuthInfo;

/**
 * feishu auth operations.
 * @author Shawn Deng
 */
public interface AuthOperations {

    /**
     * refresh user token
     * @param refreshToken refresh token
     * @return FeishuAccessToken
     * @throws FeishuApiException exception
     */
    FeishuAccessToken refreshUserAccessToken(String refreshToken) throws FeishuApiException;

    /**
     * Get user information
     * @param userAccessToken user access token
     * @return FeishuUserAuthInfo
     * @throws FeishuApiException exception
     */
    FeishuUserAuthInfo getUserInfo(String userAccessToken) throws FeishuApiException;
}
