package com.learn.springboot.redis.dataType.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zhenghailong
 * @date: 2019/9/23 15:45
 * @modified By:
 * @description:
 */
@Component
public class RedisStringUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 追加一个值到key上
     * @param key
     * @param value
     * @return
     */
    public Integer append(String key,String value){
        return redisTemplate.opsForValue().append(key, value);
    }

    /**
     * 统计字符串指定起史位置的字节数
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long bitCount(String key, int start, int end){
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes(), start, end));
    }

    /**
     * 整数原子减1
     * @param key
     * @return
     */
    public Long decrement(String key){
        return redisTemplate.opsForValue().decrement(key);
    }

    /**
     * 原子减指定整数
     * @param key
     * @param decrement
     * @return
     */
    public Long decrement(String key,Integer decrement){
        return redisTemplate.opsForValue().decrement(key,decrement);
    }

    /**
     * 获取key的value
     * @param key
     * @return
     */
    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
