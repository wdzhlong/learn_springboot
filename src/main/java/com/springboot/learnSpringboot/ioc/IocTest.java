package com.springboot.learnSpringboot.ioc;

import com.springboot.learnSpringboot.ioc.config.AppConfig;
import com.springboot.learnSpringboot.ioc.dependencyInjection.BusinessPerson;
import com.springboot.learnSpringboot.ioc.pojo.User;
import com.springboot.learnSpringboot.ioc.properties.DataSourceProperties;
import com.springboot.learnSpringboot.ioc.scan.Cat;
import com.springboot.learnSpringboot.ioc.scan.Dog;
import com.springboot.learnSpringboot.ioc.scan.UserController;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 15:04
 * @modified By:
 * @description:
 */
public class IocTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names){
            System.out.println("Bean name:"+name);
        }
        BusinessPerson dog = ioc.getBean(BusinessPerson.class);
        // 测试延迟依赖注入
        UserController userController = ioc.getBean(UserController.class);

        DataSourceProperties dataSourceProperties = ioc.getBean(DataSourceProperties.class);
        System.out.println(dataSourceProperties.getUrl());
        /*User user = ioc.getBean(User.class);
        Dog dog = ioc.getBean(Dog.class);
        Cat cat = ioc.getBean(Cat.class);
        System.out.println(user.getId());
        System.out.println(dog.getAge());
        System.out.println(cat.getAge());*/
    }
}
