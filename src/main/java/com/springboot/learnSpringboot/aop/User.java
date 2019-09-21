package com.springboot.learnSpringboot.aop;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:42
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;

    String username;

    String note;
}
