package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * feishu check user admin request.
 * </p>
 *
 * @author Shawn Deng
 */
@Getter
@Setter
@ToString
public class FeishuCheckUserAdminRequest {

    private String employeeId;

    private String openId;
}
