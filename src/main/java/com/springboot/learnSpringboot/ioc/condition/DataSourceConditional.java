package com.springboot.learnSpringboot.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 22:05
 * @modified By:
 * @description:
 */
public class DataSourceConditional implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        return environment.containsProperty("datasource.driverName") &&
                environment.containsProperty("datasource.url") &&
                environment.containsProperty("datasource.username") &&
                environment.containsProperty("datasource.password");
    }
}
