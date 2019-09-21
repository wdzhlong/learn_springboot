package com.springboot.learnSpringboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:44
 * @modified By:
 * @description:切面
 */
@Aspect
@Component
@Order(2)
public class MyAspect1 {

    /**
     * 定义切点
     * <p>
     * execution表示在执行的时候，拦截里面的正则匹配的方法
     * ”* ”表示任意返回类型的方法
     * com.springboot.learnSpringboot.aop.UserServiceImpl指定目标对象的全限定名称
     * printUser指定目标对象的方法
     * ".."表示任意参数进行匹配
     */
    @Pointcut("execution(* com.springboot.learnSpringboot.aop.UserServiceImpl.printUser(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        joinPoint.getArgs();
        System.out.println("before1 ......");
    }

    /**
     * 执行目标方法之后
     */
    @After("pointCut()")
    public void after() {
        System.out.println("after1 ......");
    }

    /**
     * 目标方法正常返回之后
     */
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning1 ......");
    }

    /**
     * 目标方法产生异常
     */
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing1 ......");
    }

    /**
     * @param proceedingJoinPoint 通过proceed()方法可以调用原有目标对象的方法
     * @throws Throwable
     */
    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before1 proceedingJoinPoint");
        proceedingJoinPoint.proceed();
        System.out.println("around after1 proceedingJoinPoint");
    }
}
