package com.learn.springboot.ioc.scan;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 15:18
 * @modified By:
 * @description:
 */
@Component
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dog {

    @Value("15")
    Integer age;

    @Value("ergou")
    String name;
}
