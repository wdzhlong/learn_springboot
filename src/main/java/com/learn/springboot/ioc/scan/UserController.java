package com.learn.springboot.ioc.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 15:49
 * @modified By:
 * @description:
 */
@Controller
public class UserController {

    private Dog dog;

    @Autowired
    @Qualifier(value = "dog")
    public void setDog(Dog dog) {
        System.out.println("延迟注入");
        this.dog = dog;
    }
}
