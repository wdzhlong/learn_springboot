package com.learn.springboot.aop;

import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 22:31
 * @modified By:
 * @description:
 */
@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口"+user.getClass().getSimpleName());
        return user != null;
    }
}
