package com.learn.springboot.jms_amqp.rabbitMQ;

import com.learn.springboot.mybatis.entity.User;
/*import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 23:02
 * @modified By:
 * @description:
 */
@Service
//public class RabbitMqServiceImpl implements RabbitMqService,RabbitTemplate.ConfirmCallback {
public class RabbitMqServiceImpl implements RabbitMqService{
    @Value("${rabbitmq.queue.msg}")
    private String msgRouting;

    @Value("${rabbitmq.queue.user}")
    private String userRouting;

    /*@Autowired
    private RabbitTemplate rabbitTemplate;*/

    @Override
    public void sendMsg(String msg) {
        System.out.println("rabbitmq send:"+msg);
        // 设置回调
        /*rabbitTemplate.setConfirmCallback(this);
        // 发送消息
        rabbitTemplate.convertAndSend(msgRouting,msg);*/
    }

    @Override
    public void sendUser(User user) {
        System.out.println("rabbitmq send user:"+ user);
        // 设置回调
        /*rabbitTemplate.setConfirmCallback(this);
        // 发送消息
        rabbitTemplate.convertAndSend(userRouting,user);*/
    }

    /**
     * 回调确认方法
     * @param correlationData
     * @param ack
     * @param cause
     */
    /*@Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack){
            System.out.println("发送成功消息");
        }else {
            System.out.println("消息发送失败:"+cause);
        }
    }*/
}
