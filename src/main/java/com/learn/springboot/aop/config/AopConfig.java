package com.learn.springboot.aop.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.learn.springboot.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
