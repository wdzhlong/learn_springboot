package com.learn.springboot.springmvc.custom;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 11:18
 * @modified By:
 * @description:
 * springmvc中，是通过WebDataBinder机制来获取参数的，它的主要作用是解析HTTP请求的上下文，然后在控制器的调用之前
 * 转换参数并且提供验证的功能，为调用控制器的方法作准备。处理器会从HTTP请求中读取数据，然后通过三种接口来进行各类
 * 参数转换。
 * 控制器的参数是通过Converter、Formatter、和GenericConverter这三个接口转换出来的
 * Converter是一个普通的转换器，例如，有一个Integer类型的控制器参数，而从HTTP对应的为字符串，对应的Convert就会将
 * 字符串转换为Integer类型
 * Formatter是一个格式化转换器，类似日期字符串就是按照约定的格式转换为日期的
 * GenericConverter转换器则将HTTP参数转换为数组
 */
//@Component
public class MyFormatConvert implements Converter<String, User> {

    @Override
    public User convert(String o) {
        User user = new User();
        String[] split = o.split("-");
        user.setUserName(split[0]);
        return user;
    }
}
