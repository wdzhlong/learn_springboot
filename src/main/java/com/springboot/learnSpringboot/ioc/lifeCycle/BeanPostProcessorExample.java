package com.springboot.learnSpringboot.ioc.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 17:12
 * @modified By:
 * @description:实现BeanPostProcessor后置处理器接口的Bean将对所有的Bean有效
 */
//@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用postProcessBeforeInitialization方法" +
                "，参数1."+bean.getClass().getSimpleName()+
                "参数2."+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用postProcessAfterInitialization方法" +
                "，参数1."+bean.getClass().getSimpleName()+
                "参数2."+beanName);
        return bean;
    }
}
