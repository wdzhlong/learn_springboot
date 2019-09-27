package com.learn.springboot.springmvc.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 20:57
 * @modified By:
 * @description:
 * @ControllerAdvice：定义一个控制器的通知类，，允许定义一些关于增强控制器的各类通知和限定增强哪些控制器功能等
 */
@org.springframework.web.bind.annotation.ControllerAdvice(
        basePackages = "com.learn.springboot.springmvc.advice.*",
        annotations = Controller.class
)
public class ControllerAdvice {
    /**
     * @param binder
     * @InitBinder:定义控制器参数绑定规，如转换规则、格式化等，它会在参数转换之前执行。
     */
    @InitBinder
    public void initDataBinder(WebDataBinder binder) {
        // 自定义日期编辑器，限定格式为yyyy-MM-dd HH:mm:ss，且不能为空
        CustomDateEditor dateEditor = new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false);
        binder.registerCustomEditor(Date.class,dateEditor);
    }

    /**
     * 可以在控制器方法执行之前，对数据模型进行操作。
     */
    @ModelAttribute
    public void projectModel(Model model){
        model.addAttribute("projectModel","projectModel");
    }

    /**
     * 定义控制器发生异常后的操作。一般来说，发生异常后，可以跳转到指定的友好页面，以避免用户使用的不友好
     * 异常处理，使得被拦截的控制器方法发生异常时，都能用相同的视图响应
     */
    @ExceptionHandler(value = Exception.class)
    public String exception(Model model,Exception ex){
        model.addAttribute("exceptionMessage",ex.getMessage());
        return "exception";
    }
}
