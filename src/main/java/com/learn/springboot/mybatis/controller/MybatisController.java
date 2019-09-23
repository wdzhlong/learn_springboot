package com.learn.springboot.mybatis.controller;

import com.learn.springboot.mybatis.dao.MybatisUserDao;
import com.learn.springboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
