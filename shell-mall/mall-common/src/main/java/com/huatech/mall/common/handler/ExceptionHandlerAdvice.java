package com.huatech.mall.common.handler;

import com.huatech.mall.common.exception.ExceptionCustomer;
import com.huatech.mall.common.response.ExceptionResponseResult;
import com.huatech.mall.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handlerException(Exception e, HttpServletRequest httpServletRequest) {

        if (e instanceof ExceptionCustomer) {
            ExceptionCustomer exceptionCustomer = (ExceptionCustomer) e;
            log.info("异常信息======", exceptionCustomer.getMessage());
            return ResponseResult.failure(exceptionCustomer.getCode(), exceptionCustomer.getMessage());
        } else {
            return ResponseResult.failure(-1, "服务器异常", 1000);

        }
    }


}
