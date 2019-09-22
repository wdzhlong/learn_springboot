package com.springboot.learnSpringboot.dataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 9:52
 * @modified By:
 * @description:
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean.getClass().getName());
    }
}
