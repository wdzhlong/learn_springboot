package com.springboot.learnSpringboot.mybatis.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 11:46
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Alias(value = "mybatisUser")
public class User {

    Integer id;

    String userName;

    Integer sex;

    String note;
}
