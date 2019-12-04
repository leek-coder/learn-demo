package com.huatech.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关业务控制器
 *
 * @author like
 * @date 2019-11-30 9:18 上午
 **/
@RestController
@RequestMapping(value = "/user")
@RefreshScope
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);



}