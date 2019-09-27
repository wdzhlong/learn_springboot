package com.learn.springboot.jms_amqp.rabbitMQ;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 23:13
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @RequestMapping("/msg")
    public String msg(String message){
        rabbitMqService.sendMsg(message);
        return "success";
    }

    @RequestMapping("/user")
    public String user(User user){
        rabbitMqService.sendUser(user);
        return "success";
    }
}
