package com.huatech.mall.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbitmq的配置类
 *
 * @author like
 * @date 2020-01-02 4:29 下午
 **/
@Configuration
public class RabbitMqConfig {
    public final static String QUEUE_NAME = "spring-boot-queue";

    public final static String EXCHANGE_NAME = "spring-boot-exchange";

    public final static String BINDING_KEY = "spring.boot.key";

    /**
     * 创建队列
     *
     * @return
     */
    @Bean
    public Queue queue() {

        return new Queue(QUEUE_NAME);

    }

    /**
     * 创建一个 direct 类型的交换器
     *
     * @return
     */
    @Bean
    public DirectExchange exchange() {

        return new DirectExchange(EXCHANGE_NAME);

    }

    /**
     * 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {

        return BindingBuilder.bind(queue).to(exchange).with(BINDING_KEY);

    }

}