package com.springboot.learnSpringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghailong
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springboot.learnSpringboot.jpa.dao")
@EntityScan(basePackages = "com.springboot.learnSpringboot.jpa.entity")
/**
 *@MapperScan:扫描加载mapper,这样就可以把bean加载到spring ioc中
 * sqlSessionTemplateRef优先级大于sqlSessionFactoryRef，当两者都配置，系统优化选择sqlSessionTemplateRef
 * 而把sqlSessionFactoryRef作废
 */
@MapperScan(basePackages = "com.springboot.learnSpringboot.mybatis.dao",
        sqlSessionFactoryRef = "sqlSessionFactory",
        sqlSessionTemplateRef = "sqlSessionTemplate",annotationClass = Repository.class)
public class SpringbootLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearnApplication.class, args);
    }

}
