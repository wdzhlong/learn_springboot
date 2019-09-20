package com.springboot.learnSpringboot.ioc.dependencyInjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 16:20
 * @modified By:
 * @description:
 */
@Component(value = "injectionCat")
@Primary
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("猫抓老鼠");
    }
}
