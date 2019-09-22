package com.springboot.learnSpringboot.jpa.controller;

import com.springboot.learnSpringboot.jpa.dao.JpaUserRepository;
import com.springboot.learnSpringboot.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 11:52
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/jpaUser")
public class JpaUserController {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @RequestMapping("/queryUser")
    public void queryUser(Integer id){
        Optional<User> user = jpaUserRepository.findById(id);
        System.out.println(user.get().getUserName());
    }

    @RequestMapping("/findUsers")
    public void findUsers(String userName,String note){
        List<User> users = jpaUserRepository.findUsers(userName, note);
        System.out.println(users.size());
    }

    @RequestMapping("/findByUserNameLike")
    public void findByUserNameLike(String userName){
        List<User> users = jpaUserRepository.findByUserNameLike(userName);
        System.out.println(users.size());
    }
}
