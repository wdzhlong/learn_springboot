package com.learn.springboot.ioc.dependencyInjection;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 16:12
 * @modified By:
 * @description:
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusinessPerson implements Person {

    public BusinessPerson(@Autowired @Qualifier(value = "injectionDog") Animal animal) {
        this.animal = animal;
    }

    /**
     * @Autowired:注入的机制最基本的一条是根据类型(by type)
     * 当有多个实现同一个接口的类型会怎么样呢？答案是spring启动的时候会报错
     * 解决方式：
     * 1.通过bean的名称命名(Animal injectionCat;这种方式不好：好好的一个动物变成猫、狗了)
     * 2.结合@Qualifier注解：指定Bean的名称，通过这个就可以消除歧义了
     * 3.@Primary:告诉spring容器，当发现有多个同样类型的bean时，请优先使用我进行注入
     * 当@Qualifier和@Primary一起使用时，@Qualifier优先
     *
     * 当然还可以使用构造器注入
     */
    @Autowired
    @Qualifier(value = "injectionDog")
    Animal animal;

    @Override
    public void service() {
        animal.use();
    }
}
