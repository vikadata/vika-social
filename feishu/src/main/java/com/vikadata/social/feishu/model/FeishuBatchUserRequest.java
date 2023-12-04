package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 * feishu batch user request.
 * </p>
 *
 * @author Shawn Deng
 */
@Getter
@Setter
@ToString
public class FeishuBatchUserRequest {

    private List<String> employeeIds;

    private List<String> openIds;
}
