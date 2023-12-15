package com.vikadata.social.qq;

/**
 * QQ exception.
 * @author Shawn Deng
 */
public class QQException extends Exception {

    /**
     * code.
     */
    private final int code;

    /**
     * Constructor.
     * @param message message
     */
    public QQException(String message) {
        this(500, message);
    }

    /**
     * Constructor.
     * @param code code
     * @param msg msg
     */
    public QQException(int code, String msg) {
        super("code :" + code + ", " + msg);
        this.code = code;
    }

    /**
     * code getter.
     * @return code
     */
    public int getCode() {
        return code;
    }
}
