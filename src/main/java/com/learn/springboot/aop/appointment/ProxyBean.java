package com.learn.springboot.aop.appointment;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:17
 * @modified By:
 * @description:
 */
public class ProxyBean implements InvocationHandler {

    private Object target;

    private Intercepter intercepter;

    /**
     *
     * @param target 存在接口
     * @param intercepter
     * @return
     */
    public static Object getProxyBean(Object target,Intercepter intercepter){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.intercepter = intercepter;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    /**
     * 处理代理对象方法逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args,method,proxy);
        return null;
    }
}
