package com.learn.springboot.ioc.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 14:57
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;

    String userName;

    String note;

    public void initMethod(){
        System.out.println("User initMethod");
    }

    public void destroyMethod(){
        System.out.println("User destroyMethod");
    }
}
