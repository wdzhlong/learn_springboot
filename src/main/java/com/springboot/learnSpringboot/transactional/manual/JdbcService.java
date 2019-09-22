package com.springboot.learnSpringboot.transactional.manual;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 17:24
 * @modified By:
 * @description:
 */
public interface JdbcService {

    int insertUser(String username,String note);
}
