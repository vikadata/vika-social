package com.vikadata.social.feishu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * feishu order detail response.
 *
 * @author zoe zheng
 */
@Setter
@Getter
@ToString
public class FeishuOrderDetailResponse extends BaseResponse {

    private Data data;

    @Setter
    @Getter
    @ToString
    public static class Data {

        private OrderDetail order;
    }

    @Setter
    @Getter
    @ToString
    public static class OrderDetail {
        private String orderId;

        private String pricePlanId;

        private String pricePlanType;

        private Integer seats;

        private String createTime;

        private String payTime;

        private String status;

        private String buyType;

        private String srcOrderId;

        private String dstOrderId;

        private Long orderPayPrice;

        private String tenantKey;
    }

}
