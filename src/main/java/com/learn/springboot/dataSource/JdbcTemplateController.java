package com.learn.springboot.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 10:36
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/jdbcTemplate")
public class JdbcTemplateController {

    @Autowired
    private JdbcTemplateService jdbcTemplateService;

    @RequestMapping("/getUser")
    public void getUser(Long id){
        jdbcTemplateService.getUser(id);
    }
}
