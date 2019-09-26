package com.learn.springboot.springmvc.verify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 14:22
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValidatorSub {

    @NotBlank
    String sub;
}
