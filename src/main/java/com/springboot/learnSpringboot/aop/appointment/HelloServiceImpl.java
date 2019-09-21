package com.springboot.learnSpringboot.aop.appointment;

import org.springframework.stereotype.Service;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:03
 * @modified By:
 * @description:
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == ""){
            throw new RuntimeException("parameter is null");
        }
        System.out.println("hello "+name);
    }
}
