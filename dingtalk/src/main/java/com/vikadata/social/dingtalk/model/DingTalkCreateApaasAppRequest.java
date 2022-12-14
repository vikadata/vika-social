package com.vikadata.social.dingtalk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Create apaas application
 */
@Setter
@Getter
@ToString
public class DingTalkCreateApaasAppRequest {

    @JsonProperty("appName")
    private String appName;

    @JsonProperty("appDesc")
    private String appDesc;

    /**
     * App icon mediaId. It can be generated by uploading multimedia files using an open interface.
     */
    @JsonProperty("appIcon")
    private String appIcon;

    /**
     * The mobile terminal opens the address.
     */
    @JsonProperty("homepageLink")
    private String homepageLink;

    /**
     * Open the address on the PC side.
     */
    @JsonProperty("pcHomepageLink")
    private String pcHomepageLink;

    /**
     * Application management address.
     */
    @JsonProperty("ompLink")
    private String ompLink;

    /**
     * Use the mobile terminal to edit the address.
     */
    @JsonProperty("homepageEditLink")
    private String homepageEditLink;

    /**
     * Use the PC side to edit the address.
     */
    @JsonProperty("pcHomepageEditLink")
    private String pcHomepageEditLink;

    /**
     * Operator user Id.
     */
    @JsonProperty("opUserId")
    private String opUserId;

    /**
     * The application id on the ISV side.
     */
    @JsonProperty("bizAppId")
    private String bizAppId;

    /**
     * Apply template key.
     */
    @JsonProperty("templateKey")
    private String templateKey;
}
