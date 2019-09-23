package com.learn.springboot.mybatis.dao;

import com.learn.springboot.mybatis.entity.User;
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

    User updateUser(User user);

    int deleteUser(Integer id);
}
