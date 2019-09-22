package com.springboot.learnSpringboot.transactional.declaration;

import com.springboot.learnSpringboot.mybatis.dao.MybatisUserDao;
import com.springboot.learnSpringboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 17:50
 * @modified By:
 * @description:
 */
@Service
public class TransactionalUserServiceImpl implements TransactionalUserService{

    @Autowired
    private MybatisUserDao mybatisUserDao;

    /**
     * @Transactional源码
     * public @interface Transactional {
     *     通过bean name指定事务管理器
     *     @AliasFor("transactionManager")
     *     String value() default "";
     *      通过bean name指定事务管理器
     *     @AliasFor("value")
     *     String transactionManager() default "";
     *     指定事务传播行为
     *     Propagation propagation() default Propagation.REQUIRED;
     *     指定事务隔离级别
     *     Isolation isolation() default Isolation.DEFAULT;
     *     指定超时时间(单位 秒)
     *     int timeout() default -1;
     *     是否只读事务
     *     boolean readOnly() default false;
     *     方法在发生指定异常时回滚，默认是所有异常都回滚
     *     Class<? extends Throwable>[] rollbackFor() default {};
     *     方法在发生指定异常名称时回滚，默认是所有异常都回滚
     *     String[] rollbackForClassName() default {};
     *     方法在发生指定异常名称时不回滚，默认是所有异常都回滚
     *     Class<? extends Throwable>[] noRollbackFor() default {};
     *      方法在发生指定异常名称时不回滚，默认是所有异常都回滚
     *     String[] noRollbackForClassName() default {};
     * }
     * @param user
     * @return
     */
    /**
     * @Transactional:继可以放在接口上也可以放在类上，推荐放在实现类上，因为放在接口上将使得你的类基于接口
     * 的代理时它才生效
     */
    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.REPEATABLE_READ,timeout = 1)
    public Integer insertUser(User user) {
        return mybatisUserDao.insertUser(user);
    }
}
