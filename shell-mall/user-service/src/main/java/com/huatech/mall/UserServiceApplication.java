package com.huatech.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户服务启动类
 *
 * @author like
 * @date 2019-11-29 9:40 下午
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.huatech.mall.mapper.*")
@EnableFeignClients
public class UserServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserServiceApplication.class, args);
    }
}