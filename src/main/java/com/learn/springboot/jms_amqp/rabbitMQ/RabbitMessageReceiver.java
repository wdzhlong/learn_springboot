package com.learn.springboot.jms_amqp.rabbitMQ;

import com.learn.springboot.mybatis.entity.User;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 23:10
 * @modified By:
 * @description:
 * 监听消息
 */
@Component
public class RabbitMessageReceiver {

    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void recieveMsg(String msg){
        System.out.println("收到消息："+msg);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void recieveUser(User user){
        System.out.println("收到消息：" + user.toString());
    }
}
