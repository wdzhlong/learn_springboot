package com.springboot.learnSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhenghailong
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springboot.learnSpringboot.jpa.dao")
@EntityScan(basePackages = "com.springboot.learnSpringboot.jpa.entity")
public class SpringbootLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearnApplication.class, args);
    }

}
