package com.springboot.learnSpringboot.mybatis.controller;

import com.springboot.learnSpringboot.mybatis.dao.MybatisUserDao;
import com.springboot.learnSpringboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 12:53
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisUserDao mybatisUserDao;

    @RequestMapping("/getUser")
    public void getUser(Integer id){
        User user = mybatisUserDao.getUser(id);
        System.out.println(user.getUserName());
    }
}
