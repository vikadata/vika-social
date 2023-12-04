package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Feishu contact scope.
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuDepartmentDetailListResponse extends BaseResponse {

    private Data data;

    @Setter
    @Getter
    @ToString
    public static class Data {

        private List<FeishuDepartmentDetail> departmentInfos;
    }
}
