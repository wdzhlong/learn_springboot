package com.learn.springboot.springmvc.format;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 10:37
 * @modified By:
 * @description:
 */
@RestController
@RequestMapping(value = "/format/")
public class FormatController {

    /**
     * @DateTimeFormat:指定日期格式
     * @NumberFormat:指定货币格式
     * @param date
     * @param number
     * @return
     */
    @PostMapping("format")
    public Map<String,Object> format(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                        @NumberFormat(pattern = "#,###.##") Double number){
        return null;
    }
}
