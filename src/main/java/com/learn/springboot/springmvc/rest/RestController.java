package com.learn.springboot.springmvc.rest;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 10:29
 * @modified By:
 * @description:在一些网站中，提出了REST风格，这时参数往往通过URL进行传递。例如获取编号为1的用户，URL就要写为
 * /user/1,这里的1代表的是用户编号
 * Springmvc对REST提供了良好的支持，可以通过处理器映射和注解@PathVariable的组合获取URL参数
 * @PathVariable可以通过名称来获取参数
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id",required = true) Integer id){
        return null;
    }
}
