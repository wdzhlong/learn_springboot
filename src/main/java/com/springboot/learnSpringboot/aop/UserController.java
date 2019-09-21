package com.springboot.learnSpringboot.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhenghailong
 * @date: 2019/9/21 22:14
 * @modified By:
 * @description:
 */
@Controller("aopUserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/printUser")
    public void pringUser(){
        User user = new User();
        user.setUsername("username");
        this.userService.printUser(user);
    }
}
