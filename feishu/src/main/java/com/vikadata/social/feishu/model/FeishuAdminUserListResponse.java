package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Feishu admin user list response.
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuAdminUserListResponse extends BaseResponse {

    private FeishuAdminUserList data;
}
