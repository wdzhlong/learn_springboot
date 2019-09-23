package com.learn.springboot.transactional.declaration;

import com.learn.springboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 18:04
 * @modified By:
 * @description:
 */
@Controller
@RequestMapping("/transactionUser")
public class TransactionUserController {

    @Autowired
    private TransactionalUserService transactionalUserService;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @RequestMapping("/insertUser")
    @ResponseBody
    public Integer insertUser(User user){
        System.out.println("查看默认事务管理器："+platformTransactionManager.getClass().getName());
        Integer result = transactionalUserService.insertUser(user);
        return result;
    }
}
