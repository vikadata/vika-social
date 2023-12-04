package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 * feishu send message batch response.
 * </p>
 *
 * @author Shawn Deng
 */
@Setter
@Getter
@ToString
public class FeishuSendMessageBatchResponse extends BaseResponse {

    private Data data;

    @Setter
    @Getter
    @ToString
    public static class Data {

        private List<String> invalidDepartmentIds;

        private List<String> invalidOpenIds;

        private List<String> invalidUserIds;

        private String messageId;
    }
}
