package com.learn.springboot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 21:35
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/async")
public class AsyncController {

    @RequestMapping("/page")
    @Async // 声名使用异步调用
    public void async(){
        System.out.println("请求线程名称:"+Thread.currentThread().getName());
    }
}
