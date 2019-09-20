package com.springboot.learnSpringboot.ioc.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 22:39
 * @modified By:
 * @description:
 */
@Configuration
public class DataSourceProfileConfig {

    /**
     * @Profile:可以方便地实现各个环境的切换
     */
    @Bean
    @Profile("dev")
    public DataSource devDataSource(){

        return null;
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource(){

        return null;
    }
}
