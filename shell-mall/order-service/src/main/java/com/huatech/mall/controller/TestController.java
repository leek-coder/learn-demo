package com.huatech.mall.controller;

import com.huatech.mall.common.response.ResponseResult;
import com.huatech.mall.service.ISendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author like
 * @date 2020-01-02 4:41 下午
 **/
@RestController
@RequestMapping(value = "/send")
public class TestController {

    @Autowired
    private ISendMessageService sendMessageService;


    @RequestMapping(value = "/test")
    public ResponseResult send() {

        sendMessageService.send("李苛");
        return ResponseResult.success();
    }
}