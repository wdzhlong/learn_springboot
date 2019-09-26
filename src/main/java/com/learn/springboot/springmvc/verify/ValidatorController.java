package com.learn.springboot.springmvc.verify;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 14:27
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/validator")
public class ValidatorController {

    @PostMapping("/validator")
    @ResponseBody
    public String validator(@Valid ValidatorPojo pojo, Model model, ModelAndView modelAndView, ModelMap modelMap){
        return "较验成功";
    }
}
