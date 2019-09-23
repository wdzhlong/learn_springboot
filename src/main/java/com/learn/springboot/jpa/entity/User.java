package com.learn.springboot.jpa.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 11:46
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "user")
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_name")
    String userName;

    @Column(name = "sex")
    Integer sex;

    @Column(name = "note")
    String note;
}
