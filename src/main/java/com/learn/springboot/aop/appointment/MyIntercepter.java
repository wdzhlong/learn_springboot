package com.learn.springboot.aop.appointment;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:14
 * @modified By:
 * @description:
 */
public class MyIntercepter implements Intercepter {
    @Override
    public boolean before() {
        System.out.println("before .......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ......");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ......");
        Object obj = invocation.proceed();
        System.out.println("around after ......");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
