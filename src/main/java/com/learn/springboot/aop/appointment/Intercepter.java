package com.learn.springboot.aop.appointment;


import java.lang.reflect.InvocationTargetException;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:05
 * @modified By:
 * @description:
 */
public interface Intercepter {
    /**
     * 事前方法
     * @return
     */
    boolean before();

    /**
     * 事后方法
     */
    void after();

    /**
     * 取代原有事件方法
     * @param invocation
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    /**
     * 是否返回方法，事件没有发生异常执行
     */
    void afterReturning();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    void afterThrowing();

    /**
     * 是否使用around方法取代原有方法
     * @return
     */
    boolean useAround();
}
