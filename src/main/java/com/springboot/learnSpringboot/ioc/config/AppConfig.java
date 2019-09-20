package com.springboot.learnSpringboot.ioc.config;

import com.springboot.learnSpringboot.ioc.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 14:59
 * @modified By:
 * @description:
 */

/**
 * @Configuration 代表这是一个java配置文件，spring的容器会根据它来生成ioc容器去装配bean
 * @Bean 代表将initUser方法返回的POJO装配到IOC容器中，而其属性name定义这个bean的名称，如果没有配置它，则将
 * 方法名称initUser作为bean的名称保存到Sping Ioc容器中.
 * initMethod指定Bean初始化方法
 * destroyMethod指定Bean销毁方法
 * @ComponentScan:该注解默认会扫描该类所在的包下所有的配置类
 * value或者basePackages:指定要扫描的包，包括扫描的包的子包
 * excludeFilters:excludeFilters 的参数是一个 Filter[] 数组，然后指定 FilterType 的类型为 ANNOTATION，
 * 也就是通过注解来过滤，最后的 value 则是Controller 注解类。配置之后，在 spring 扫描的时候，
 * 就会跳过com.springboot.learnSpringboot.ioc.scan包下，所有被 @Controller 注解标注的类。
 * includeFilters:扫描包含指定规则的bean,和excludeFilters用法一样
 * useDefaultFilters:该属性默认值为 true，也就是说 spring 默认会自动发现被 @Component、@Repository、@Service 和 @Controller 标注的类，并注册进容器中。
 * 如果使用includeFilters，则可以把useDefaultFilters设置为false
 * lazyInit
 * @PropertySource:加载指定属性文件到 Spring 的 Environment 中
 * @ImportResource：引入外部资源
 */
@Configuration
@ComponentScan(basePackages = "com.springboot.learnSpringboot.ioc"
                //,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})}
                ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})}
                ,useDefaultFilters = true,lazyInit = false)
@PropertySource(value = "classpath:jdbc.properties")
@EnableConfigurationProperties
@ImportResource(value = "classpath:spring-other.xml")
public class AppConfig {

    @Bean(name = "user",initMethod = "initMethod",destroyMethod = "destroyMethod")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("zhenghailong");
        user.setNote("note");
        return user;
    }
}
