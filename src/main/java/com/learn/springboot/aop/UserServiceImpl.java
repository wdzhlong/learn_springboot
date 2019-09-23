package com.learn.springboot.aop;

import org.springframework.stereotype.Service;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 21:43
 * @modified By:
 * @description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public void printUser(User user) {
        /*System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getNote());*/
    }
}
