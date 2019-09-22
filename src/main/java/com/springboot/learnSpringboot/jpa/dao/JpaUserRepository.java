package com.springboot.learnSpringboot.jpa.dao;

import com.springboot.learnSpringboot.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 11:51
 * @modified By:
 * @description:
 */
public interface JpaUserRepository extends JpaRepository<User,Integer> {
    /**
     * JPQL
     * @param userName
     * @param note
     * @return
     */
    @Query("from user where user_name like concat('%',?1,'%') " +
            "and note like concat('',?2,'%') ")
    List<User> findUsers(String userName,String note);

    /**
     * 按用户名称模糊查询,指定规则不用写JPQL
     * 这里的命名是以动词（ get/find ）开始的，而以 by 代表按照什么内容进行查询。
     * 例如，getUserByld 方法就是通过主键（ id ）对用户进行查询的，这样 JPA 就会根据方法命名生成 SQL 来查
     * 询数据库了： find.ByU serNameLike 法的命名则多了一个 like ，它代表着采用模糊查询，也就是使
     * 用like 关键宇进行查询 findByUserN ameLikeOrN oteLike 样的命名，则涉及两个条件，一个是用
     * 户名（ userName ）， 另一个是备注（ note ），它们都采用了 like ，因此会执行模糊查询，而它们之间采
     * 用的连接词为 Or 或者） ，所以 SQL 的生成也采用了 Or 。
     * @param userName
     * @return
     */
    List<User> findByUserNameLike(String userName);

    User getUSerById(Long id);

    List<User> findByUserNameLikeOrNoteLike(String userName,String note);
}
