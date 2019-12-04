package com.huatech.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户鉴权服务
 *
 * @author like
 * @date 2019-11-30 10:12 上午
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class UserAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthServiceApplication.class,args);
    }
}