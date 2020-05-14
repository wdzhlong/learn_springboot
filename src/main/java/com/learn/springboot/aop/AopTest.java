package com.learn.springboot.aop;

import com.learn.springboot.aop.config.AopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 22:04
 * @modified By:
 * @description:
 */
public class AopTest {

    public static void main(String[] args) {
        String a = "test";
        ApplicationContext ioc = new AnnotationConfigApplicationContext(AopConfig.class);
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names){
            System.out.println("Bean name:"+name);
        }
        UserService userService = ioc.getBean(UserService.class);
        User user = new User();
        user.setUsername("wo de username");
        userService.printUser(user);

    }
}
