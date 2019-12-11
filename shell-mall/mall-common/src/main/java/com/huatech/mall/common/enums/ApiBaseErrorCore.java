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
    PASSWORD_ERROR("密码错误", 1002),


    ROLE_NOT_EXISTS("角色不存在", 2000),
    ROLE_EXISTS("角色已存在", 2001),
    RESOURCE_NOT_EXISTS("资源不存在", 3000),


    TOKEN_FAIL("Token验证失败", 4000),

    REMOTE_SERVICE_FAIL("远程服务调用失败",5000),
    JSON_TRANS_ERROR("参数转化异常",5001),
    AUTH_REMOTE_FAIL("远程调用鉴权服务失败",5002),

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