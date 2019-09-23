package com.learn.springboot.aop.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.springboot.learnSpringboot.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
