package com.springboot.learnSpringboot.mybatis.dao;

import com.springboot.learnSpringboot.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 12:48
 * @modified By:
 * @description:
 */
@Repository
public interface MybatisUserDao {

    User getUser(Integer id);

    Integer insertUser(User user);
}
