package com.huatech.mall.common.handler;

import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.response.ExceptionResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author leek
 * @Date 2019-06-14 下午5:41
 * @Version 1.0
 * @Description 全局异常处理类
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResponseResult handlerException(Exception e, HttpServletRequest httpServletRequest) {

        if (e instanceof ExceptionCustomer) {
            ExceptionCustomer exceptionCustomer = (ExceptionCustomer) e;
            return ExceptionResponseResult.failure(exceptionCustomer.getCode(), exceptionCustomer.getMessage(), exceptionCustomer.getErrorCode(),httpServletRequest.getRequestURI());
        }
        else{
            return ExceptionResponseResult.failure(-1, "失败", 1000,null);

        }
    }


}
