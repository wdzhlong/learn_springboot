package com.learn.springboot.jms_amqp.activeMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 22:41
 * @modified By:
 * @description:
 */
@Service
public class ActivemqServiceImpl implements ActivemqService {
    /**
     * 注入spring自动生成的JmsTemplate
     */
    //@Autowired
    private JmsTemplate jmsTemplate = null;

    @Override
    public void sendMsg(String message) {
        System.out.println(message);
        jmsTemplate.convertAndSend(message);
        // 自定义发送地址
        //jmsTemplate.convertAndSend("your-destination",message);
    }

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    @Override
    public void receiveMsg(String message) {
        System.out.println("接收到的消息："+message);
    }
}
