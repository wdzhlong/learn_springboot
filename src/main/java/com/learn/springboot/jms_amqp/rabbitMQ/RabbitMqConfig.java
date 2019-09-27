package com.learn.springboot.jms_amqp.rabbitMQ;

//import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 22:57
 * @modified By:
 * @description:
 */
@Configuration
public class RabbitMqConfig {

    @Value(value = "${rabbitmq.queue.msg}")
    private String msgQueueName;

    @Value(value = "${rabbitmq.queue.user}")
    private String userQueueName;

    /*@Bean
    public Queue creqteQueueMsg(){
        // 创建字符串消息队列，boolean值代表是否持久化消息
        return new Queue(msgQueueName,true);
    }

    @Bean
    public Queue creqteQueueUser(){
        // 创建用户消息队列，boolean值代表是否持久化消息
        return new Queue(msgQueueName,true);
    }*/
}
