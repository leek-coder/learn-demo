package com.huatech.mall.common.response;


import java.io.Serializable;


public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -1491499610244557029L;
    public static int CODE_SUCCESS = 0;
    public static int CODE_FAIL = -1;
    public static String[] NOOP = new String[]{};

    private int code; // 处理状态：0: 成功
    private String message;
    private T data; // 返回数据

    private ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 处理成功
     * 消息
     *
     * @return data
     */
    public static final ResponseResult success() {
        return new ResponseResult(CODE_SUCCESS, "成功", NOOP);
    }

    /**
     * 处理成功
     *
     * @param message 消息
     * @return data
     */
    public static final ResponseResult success(String message) {
        return new ResponseResult(CODE_SUCCESS, message, NOOP);
    }

    /**
     * 处理成功
     *
     * @param data    数据对象
     * @return data
     */
    public static final ResponseResult success(Object data) {
        return new ResponseResult(CODE_SUCCESS,"成功", data);
    }

    /**
     * 处理失败，并返回数据（一般为错误信息）
     *
     * @param code    错误代码
     * @param message 消息
     * @return data
     */
    public static final ResponseResult failure(int code, String message, int errorCode) {
        return new ResponseResult(code, message, NOOP);
    }

    public static final ResponseResult failure(int code, String message) {
        return new ResponseResult(code, message, NOOP);
    }

    /**
     * 处理失败
     *
     * @param message 消息
     * @return data
     */
    public static final ResponseResult failure(String message, int errorCode) {
        return failure(CODE_FAIL, message, errorCode);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
