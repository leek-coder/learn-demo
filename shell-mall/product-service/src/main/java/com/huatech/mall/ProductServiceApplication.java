package com.huatech.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 商品服务启动类
 *
 * @author like
 * @date 2019-11-29 9:42 下午
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.huatech.mall.service.mapper.*")
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class,args);
    }
}