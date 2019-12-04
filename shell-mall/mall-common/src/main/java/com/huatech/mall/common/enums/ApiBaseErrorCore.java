package com.huatech.mall.common.enums;

/**
 * 系统错误码
 *
 * @author like
 * @date 2019-11-30 9:09 上午
 **/
public enum ApiBaseErrorCore {
    MISS_PARAM_ERROR("参数缺失", 5000),

    USER_NOT_EXISTS("用户不存在", 1000),
    USER_EXISTS("用户已存在", 1001),

    ;


    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ApiBaseErrorCore(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}