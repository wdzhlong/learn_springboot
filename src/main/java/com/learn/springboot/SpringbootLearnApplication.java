package com.learn.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghailong
 */
@SpringBootApplication
// jpa的配置
@EnableJpaRepositories(basePackages = "com.learn.springboot.jpa.dao")
@EntityScan(basePackages = "com.learn.springboot.jpa.entity")
/**
 *@MapperScan:扫描加载mapper,这样就可以把bean加载到spring ioc中
 * sqlSessionTemplateRef优先级大于sqlSessionFactoryRef，当两者都配置，系统优化选择sqlSessionTemplateRef
 * 而把sqlSessionFactoryRef作废
 */
@MapperScan(basePackages = "com.learn.springboot.mybatis.dao",
        sqlSessionFactoryRef = "sqlSessionFactory",
        sqlSessionTemplateRef = "sqlSessionTemplate",annotationClass = Repository.class)
// 启动spring缓存机制
@EnableCaching
public class SpringbootLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearnApplication.class, args);
    }

}
