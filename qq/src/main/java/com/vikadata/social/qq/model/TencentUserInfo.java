package com.vikadata.social.qq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * QQ user info
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TencentUserInfo extends BaseResponse {

    private String nickname;

    private String gender;

    private Integer genderType;

    private String province;

    private String city;

    private String year;

    private String constellation;

    @JsonProperty("figureurl")
    private String figureUrl;

    @JsonProperty("figureurl_1")
    private String figureUrl1;

    @JsonProperty("figureurl_2")
    private String figureUrl2;

    @JsonProperty("figureurl_qq_1")
    private String figureurlQq1;

    @JsonProperty("figureurl_qq_2")
    private String figureurlQq2;
}
