package com.springboot.learnSpringboot.ioc.lifeCycle;

import com.springboot.learnSpringboot.ioc.dependencyInjection.Animal;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 16:53
 * @modified By:
 * @description:bean生命周期单个bean可以实现的所有接口
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LifeCycleImpl implements LifeCycle, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    Animal animal;

    @Override
    public void service() {
        animal.use();
    }

    @Autowired
    @Qualifier(value = "injectionDog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + "调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(this.getClass().getSimpleName() + "调用BeanNameAware的setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + "调用DisposableBean的destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + "调用InitializingBean的afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + "调用ApplicationContextAware的setApplicationContext");
    }

    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getSimpleName() + "调用注解@PostConstruct定义的自定义初始化方法");
    }

    @PreDestroy
    public void destroy1(){
        System.out.println(this.getClass().getSimpleName() + "调用注解@PreDestroy定义的自定义销毁方法");
    }
}
