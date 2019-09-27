package com.learn.springboot.jms_amqp.activeMQ;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 22:41
 * @modified By:
 * @description:
 */
public interface ActivemqService {
    /**
     * 发送消息
      * @param message
     */
    public void sendMsg(String message);

    /**
     * 接收消息
     * @param message
     */
    public void receiveMsg(String message);
}
