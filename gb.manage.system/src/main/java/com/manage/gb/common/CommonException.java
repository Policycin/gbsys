package com.manage.gb.common;

public class CommonException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;

    private String msg;

    public CommonException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String message, String code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String message, Throwable cause, String code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(Throwable cause, String code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
