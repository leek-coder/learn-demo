package com.huatech.mall.service;

/**
 * 发送消息service
 *
 * @author like
 * @date 2020-01-02 4:36 下午
 **/
public interface ISendMessageService {
    /**
     * 发送消息
     *
     * @param message
     */
    void send(String message);
}