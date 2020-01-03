package com.huatech.mall.service.impl;

import com.huatech.mall.config.RabbitMqConfig;
import com.huatech.mall.service.ISendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送消息实现类
 *
 * @author like
 * @date 2020-01-02 4:39 下午
 **/
@Service
@Slf4j
public class SendMessageServiceImpl implements ISendMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String message) {
         rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME,
                 RabbitMqConfig.BINDING_KEY,message);
    }
}