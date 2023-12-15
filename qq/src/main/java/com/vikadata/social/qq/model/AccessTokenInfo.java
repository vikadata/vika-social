package com.vikadata.social.qq.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Authorization Token Information
 */
public class AccessTokenInfo {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * get access token
     * @return access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * set access token
     * @param accessToken access token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * get expires in
     * @return expires in
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * set expires in
     * @param expiresIn expires in
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * get refresh token
     * @return refresh token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * set refresh token
     * @param refreshToken refresh token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
