package com.learn.springboot.dataSource;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author: zhenghailong
 * @date: 2019/9/22 10:26
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Integer id;

    String userName;

    Integer sex;

    String note;
}
