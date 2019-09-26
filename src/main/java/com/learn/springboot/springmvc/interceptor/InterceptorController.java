package com.learn.springboot.springmvc.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhenghailong
 * @date: 2019/9/25 17:17
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @ResponseBody
    @PostMapping("/interceptor")
    public String interceptor(){
        System.out.println("执行处理器");
        return "success";
    }
}
