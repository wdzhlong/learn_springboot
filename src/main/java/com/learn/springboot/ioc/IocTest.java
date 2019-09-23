package com.learn.springboot.ioc;

import com.learn.springboot.ioc.config.AppConfig;
import com.learn.springboot.ioc.dependencyInjection.BusinessPerson;
import com.learn.springboot.ioc.el.ElCompoment;
import com.learn.springboot.ioc.properties.DataSourceProperties;
import com.learn.springboot.ioc.scan.UserController;
import com.learn.springboot.ioc.scope.ScopeBean;
import com.learn.springboot.ioc.xml.XmoPojo;
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

        ScopeBean scopeBean1 = ioc.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ioc.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);

        XmoPojo xmoPojo = ioc.getBean(XmoPojo.class);
        System.out.println(xmoPojo.getName());

        ElCompoment elCompoment = ioc.getBean(ElCompoment.class);
        System.out.println(elCompoment.getName());
        System.out.println(elCompoment.getInitTime());
        System.out.println(elCompoment.getNameUpper());
        System.out.println(elCompoment.getFlag());
        /*User user = ioc.getBean(User.class);
        Dog dog = ioc.getBean(Dog.class);
        Cat cat = ioc.getBean(Cat.class);
        System.out.println(user.getId());
        System.out.println(dog.getAge());
        System.out.println(cat.getAge());*/
    }
}
