package com.huatech.mall.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.codec.Encoder;

/**
 * @Author leek
 * @Date 2019-11-14 上午11:01
 * @Version 1.0
 * @Description
 */
@Configuration
public class FeignMultipartSupportConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder feignEncoder() {
        return new SpringMultipartEncoder(new SpringEncoder(messageConverters));

    }
}
