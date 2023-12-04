package com.vikadata.social.feishu.model;

/**
 * feishu error.
 * @author Shawn Deng
 */
public class FeishuError {

    private final Integer code;

    private final String msg;

    public FeishuError(Integer code, String msg) {
        this.code = code != null && code != 0 ? code : null;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
