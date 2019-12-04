package com.huatech.zull;

import com.huatech.zull.fitler.ZuulCustomerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 网关服务启动类
 *
 * @author like
 * @date 2019-11-30 10:16 上午
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class ZuulServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApplication.class, args);
    }


    /**
     * 注册zuul拦截器
     * @return
     */
    @Bean
    public ZuulCustomerFilter customerFilter(){
        return  new ZuulCustomerFilter();
    }
}