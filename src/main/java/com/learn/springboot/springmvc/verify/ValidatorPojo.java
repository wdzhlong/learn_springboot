package com.learn.springboot.springmvc.verify;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @author: zhenghailong
 * @date: 2019/9/24 11:37
 * @modified By:
 * @description:
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValidatorPojo {
    /**
     * 验证对象是否为空
     */
    @Null
    String nul;
    /**
     * 验证对象是否不为空，无法检查长度为0的字符串
     */
    @NotNull(message = "notNull不能为空")
    String notNul;
    /**
     * 检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格
     */
    @NotBlank(message = "notBlank不能为空")
    String notBlank;
    /**
     * 检查约束元素是否为NULL或者是EMPTY
     */
    @NotEmpty
    List<String> notEmpty;
    /**
     * 验证 Boolean 对象是否为 true
     */
    @AssertTrue
    Boolean assertTrue;

    /**
     * 验证 Boolean 对象是否为 false
     */
    @AssertFalse
    Boolean assertFalse;
    /**
     * 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内
     */
    @Size
    String size;
    /**
     * 验证带批注的字符串是否介于包含的最小值和最大值之间
     */
    @Length(min = 1,max = 3)
    String length;
    /**
     * 验证 Date 和 Calendar 对象是否在当前时间之前，验证成立的话被注释的元素一定是一个过去的日期
     */
    @Past
    Date past;
    /**
     * 验证 Date 和 Calendar 对象是否在当前时间之后 ，验证成立的话被注释的元素一定是一个将来的日期
     */
    @Future
    Date future;
    /**
     * 验证 String 对象是否符合正则表达式的规则，被注释的元素符合制定的正则表达式，regexp:正则表达式 flags: 指定 Pattern.Flag 的数组，表示正则表达式的相关选项
     */
    @Pattern(regexp = "aaa")
    String pattern;
    /**
     * 验证 Number 和 String 对象是否大于等于指定的值
     */
    @Min(1)
    Integer min;
    /**
     * 验证 Number 和 String 对象是否小于等于指定的值
     */
    @Max(10)
    Integer max;
    /**
     *  被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
     */
    @DecimalMax(value = "3")
    Integer decimalMax;
    /**
     * 被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度
     */
    @DecimalMin(value = "3.14")
    Double decimalMin;
    /**
     * 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。
     */
    @Digits(integer = 3,fraction = 2)
    String digits;
    /**
     * 被指定的元素必须在合适的范围内
     */
    @Range(min = 1,max = 10)
    Integer range;
    /**
     * 递归的对关联对象进行校验, 如果关联对象是个集合或者数组,那么对其中的元素进行递归校验,如果是一个map,则对其中的值部分进行校验.(是否进行递归验证)
     */
    @Valid
    ValidatorSub validatorSub;
    /**
     * 信用卡卡号验证
     */
    @CreditCardNumber
    String creditCardNumber;
    /**
     * 验证是否是邮件地址，如果为null,不进行验证，算通过验证。
     */
    @Email
    String email;
    /**
     * URL验证
     */
    @URL(protocol = "http")
    String url;
}
