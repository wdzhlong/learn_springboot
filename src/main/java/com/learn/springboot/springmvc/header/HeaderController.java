package com.learn.springboot.springmvc.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 21:11
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/header")
public class HeaderController {

    @ResponseBody
    public String header(@RequestHeader("Content-Type") String header){
        System.out.println(header);
        return "header";
    }
}
