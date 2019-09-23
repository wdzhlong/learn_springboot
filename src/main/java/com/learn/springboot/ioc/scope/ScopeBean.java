package com.learn.springboot.ioc.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 22:29
 * @modified By:
 * @description:
 */

/**
 * @Scope:用于设置Bean的作用域，具体说明scope.txt
 * 具有多线程案例问题的类建议不要使用单例
 *
 * ConfigurableBeanFactory只能提供单例和原型两种作用域
 * 如果在springmvc环境中，可以使用WebApplicationContext来定义其他作用域
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScopeBean {
}
