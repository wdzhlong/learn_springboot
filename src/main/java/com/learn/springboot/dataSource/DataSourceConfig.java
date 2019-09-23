package com.learn.springboot.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 10:00
 * @modified By:
 * @description:
 */
@Configuration
public class DataSourceConfig {

    /*@Bean(name = "druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }*/
}
