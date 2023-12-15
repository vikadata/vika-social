package com.vikadata.social.qq.model;

/**
 * base response.
 * @author Shawn Deng
 */
public class BaseResponse {

    /**
     * ret.
     */
    private Integer ret;

    /**
     * msg.
     */
    private String msg;

    /**
     * ret getter.
     * @return ret
     */
    public Integer getRet() {
        return ret;
    }

    /**
     * ret setter.
     * @param ret ret
     */
    public void setRet(Integer ret) {
        this.ret = ret;
    }

    /**
     * msg getter.
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * msg setter.
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
