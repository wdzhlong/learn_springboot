package com.learn.springboot.springmvc.param;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 10:05
 * @modified By:
 * @description:
 */
@RestController
@RequestMapping("/param/")
public class ParamController {
    /**
     * 无注解的情况下，参数允许为空，唯一的要求是参数名称和HTTP请求的参数名称保持一致
     * @param intval
     * @param str
     * @return
     */
    @GetMapping("noAnnotation")
    public Map<String,Object> noAnnotation(Integer intval,String str){
        HashMap<String, Object> parm = new HashMap<>();
        return parm;
    }

    /**
     * @RequestParam:指定参数的名称，默认不能为空，通过设置属性required = false来允许为空
     * @param intval
     * @param str
     * @return
     */
    @PostMapping("requestParam")
    public Map<String,Object> requestParam(@RequestParam(value = "int_val",required = false) Integer intval, String str){
        HashMap<String, Object> parm = new HashMap<>();
        return parm;
    }

    /**
     * @RequestParam:指定参数的名称，默认不能为空，通过设置属性required = false来允许为空
     * @return
     * longArr=1,2,3
     */
    @PostMapping("requestArray")
    public Map<String,Object> requestArray(Long[] longArr){
        HashMap<String, Object> parm = new HashMap<>();
        return parm;
    }

    /**
     * @RequestBody:表示接收json格式请求体
     * @param user
     * @return
     */
    @PostMapping("requestJson")
    public Map<String,Object> requestJson(@RequestBody User user){
        HashMap<String, Object> parm = new HashMap<>();
        return parm;
    }
}
