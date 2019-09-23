package com.learn.springboot.redis.pub_sub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/23 16:58
 * @modified By:
 * @description:为了接收redis渠道发送过来的消息，定以一个消息监听器（MessageListener）
 */
@Component
public class RedisMessageListener implements MessageListener {

    /**
     * 监听消息
     * @param message
     * @param bytes
     * 命令行发布消息命令：publish topicl msg
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        // 消息体
        String body = new String(message.getBody());
        // 渠道名称
        String topic = new String(bytes);

        System.out.println(body);
        System.out.println(topic);
    }
}
