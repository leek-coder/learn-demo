package com.huatech.mall.component;

import com.huatech.mall.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author like
 * @date 2020-01-02 4:59 下午
 **/
@Component
public class MessageConsume {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void consumeMessage(String message) {
        System.out.println("接收到的消息"+message);
    }
}