package com.huatech.mall.common.response;

import java.io.Serializable;


public class ExceptionResponseResult implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;
    public static int CODE_FAIL = -1;
    private int code; // 处理状态：0: 成功
    private String message;
    private int errorCode; //错误码
    private String request_url;

    private ExceptionResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static final ExceptionResponseResult failure(int code, String message, int errorCode, String request_url) {
        return new ExceptionResponseResult(code, message, errorCode, request_url);
    }

    public static final ExceptionResponseResult failure(int code, String message) {
        return new ExceptionResponseResult(code, message);
    }

    /**
     * 处理失败
     *
     * @param message 消息
     * @return data
     */
    public static final ExceptionResponseResult failure(String message, int errorCode, String request_url) {
        return failure(CODE_FAIL, message, errorCode, request_url);
    }

    public ExceptionResponseResult(int code, String message, int errorCode, String request_url) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
        this.request_url = request_url;
    }
}
