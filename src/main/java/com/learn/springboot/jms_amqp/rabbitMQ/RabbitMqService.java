package com.learn.springboot.jms_amqp.rabbitMQ;

import com.learn.springboot.mybatis.entity.User;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 23:01
 * @modified By:
 * @description:
 */
public interface RabbitMqService {
    /**
     * 发送字符串消息
     * @param msg
     */
    public void sendMsg(String msg);

    /**
     * 发送用户消息
     * @param user
     */
    public void sendUser(User user);
}
