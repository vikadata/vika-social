package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * feishu department detail response.
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuDepartmentDetailResponse extends BaseResponse {

    private Data data;

    @Setter
    @Getter
    @ToString
    public static class Data {

        private FeishuDepartmentDetail departmentInfo;
    }
}
