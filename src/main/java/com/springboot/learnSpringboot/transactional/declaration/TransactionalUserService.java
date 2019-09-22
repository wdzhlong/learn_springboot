package com.springboot.learnSpringboot.transactional.declaration;

import com.springboot.learnSpringboot.mybatis.entity.User;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 17:49
 * @modified By:
 * @description:
 */
public interface TransactionalUserService {

    Integer insertUser(User user);
}
