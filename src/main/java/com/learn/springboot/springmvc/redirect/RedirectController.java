package com.learn.springboot.springmvc.redirect;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author: zhenghailong
 * @date: 2019/9/27 20:38
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @RequestMapping("/redirect1")
    public String redirect1(User user){
        return "redirect:/redirect/redirect2?id=1";
    }

    /**
     * 被addFlashAttribute方法保存的参数，在控制器执行完成后，会被保存到 Session 对象中.
     * 当执行重定向时 在进入重定向前首先把 Sessio 中的参数取出，用以填充重定向方法的参数和数据
     * 模型，之后删除 Sess ion 中的数据，然后就可以调用重定向方法，并将对象传递给重定向的方法。
     * @param user
     * @param ra
     * @return
     */
    @RequestMapping("/redirect2")
    public String redirect2(User user, RedirectAttributes ra){
        // 保存需要传递给重定向的对向
        ra.addFlashAttribute("user",user);
        return "redirect:/redirect/redirect1";
    }
}
