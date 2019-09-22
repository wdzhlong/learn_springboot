package com.springboot.learnSpringboot.ioc.condition;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 22:10
 * @modified By:
 * @description:
 */
@Configuration
@Component("iocDataSourceConfig")
public class DataSourceConfig {
    /**
     *@Conditional是Spring4新提供的注解，它的作用是按照一定的条件进行判断，满足条件给容器注册bean。
     */
    @Bean(name = "dataSource")
    @Conditional(DataSourceConditional.class)
    public DataSource dataSource(@Value("${datasource.url}") String url,
                                 @Value("${datasource.username}") String username,
                                 @Value("${datasource.password}") String password,
                                 @Value("${datasource.driverName}") String driverName){

        return null;
    }
}
