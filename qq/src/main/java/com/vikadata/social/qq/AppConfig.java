package com.vikadata.social.qq;

/**
 * Application configuration
 */
public class AppConfig {

    /**
     * appId
     */
    private String appId;

    /**
     * appKey
     */
    private String appKey;

    /**
     * callback uri
     */
    private String redirectUri;

    /**
     * apply union
     */
    private Boolean applyUnion = true;

    /**
     * get appId
     * @return appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * set appId
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * get appKey
     * @return appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * set appKey
     * @param appKey appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * get redirect uri
     * @return redirect uri
     */
    public String getRedirectUri() {
        return redirectUri;
    }

    /**
     * set redirect uri
     * @param redirectUri redirect uri
     */
    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    /**
     * get apply union
     * @return apply union
     */
    public Boolean getApplyUnion() {
        return applyUnion;
    }

    /**
     * set apply union
     * @param applyUnion apply union
     */
    public void setApplyUnion(Boolean applyUnion) {
        this.applyUnion = applyUnion;
    }
}
