package com.learn.springboot.springmvc.session;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 20:48
 * @modified By:
 * @description:
 * @SessionAttributes指定数据模型名称或者属性类型，保存到session中
 * names和types是或者的关系
 */
@SessionAttributes(names = "user",types = Long.class)
@Controller
@RequestMapping("/session")
public class SessionController {

    /**
     * @SessionAttribute:从HttpSession中取出数据，填充控制器方法参数
     */
    @GetMapping("/test")
    @ResponseBody
    public String test(@SessionAttribute("id")Long id, Model model){
        model.addAttribute("id_new",id);
        model.addAttribute("user",new User());
        return "session";
    }
}
