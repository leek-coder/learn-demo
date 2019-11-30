package com.huatech.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付服务启动类
 *
 * @author like
 * @date 2019-11-29 9:43 下午
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}