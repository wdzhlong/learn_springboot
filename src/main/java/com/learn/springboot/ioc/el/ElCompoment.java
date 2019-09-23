package com.learn.springboot.ioc.el;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 23:03
 * @modified By:
 * @description:
 */
@Component
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ElCompoment {
    /**
     * T(......)代表引入类;System是java.lang.*包的类，这是Java默认加载的包，因此可以不必写全限定名，
     * 如果是其他的包，则需要写出全限定名才能引用类。currentTimeMillis()是它的静态方法
     */
    @Value("#{T(System).currentTimeMillis()}")
    Long initTime;

    @Value("#{'这是一个字符串值'}")
    String str;

    @Value("#{3.1415926}")
    Double dou;
    /**
     * #{beanName.str}
     * 这里的beanName是spring ioc容器bean的名称。str是他的属性
     */
    @Value("#{xmoPojo.name}")
    String name;
    /**
     * ?号是判断这个属性是否为空，如果不为空才去执行toUpperCase()
     */
    @Value("#{xmoPojo.name?.toUpperCase()}")
    String nameUpper;

    @Value("#{1+2}")
    int run;

    @Value("#{true == false}")
    Boolean flag;
}
