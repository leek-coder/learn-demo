package com.huatech.mall.common.response;

import java.io.Serializable;

/**
 * @ClassName ExceptionResponseResult
 * @Description TODO
 * @Author like
 * @Date 2019-12-08 13:33
 * @Version 1.0
 **/
public class ExceptionResponseResult implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;
    public static int CODE_FAIL = 5000;
    /**
     * 处理状态：200: 成功
     */
    private int code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 请求路径
     */
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
