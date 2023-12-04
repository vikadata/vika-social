package com.vikadata.social.qq;

/**
 * QQ exception.
 * @author Shawn Deng
 */
public class QQException extends Exception {

    private final int code;

    public QQException(String message) {
        this(500, message);
    }

    public QQException(int code, String msg) {
        super("code :" + code + ", " + msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
