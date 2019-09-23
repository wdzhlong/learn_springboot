package com.learn.springboot.dataSource;

import java.util.List;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 10:28
 * @modified By:
 * @description:
 */
public interface JdbcTemplateService {

    User getUser(Long id);

    List<User> findUsers(String username,String note);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
