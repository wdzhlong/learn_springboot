package com.springboot.learnSpringboot.ioc.dependencyInjection;

import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 16:14
 * @modified By:
 * @description:
 */
@Component(value = "injectionDog")
public class Dog implements Animal {

    @Override
    public void use() {
        System.out.println("狗是看门用的");
    }
}
