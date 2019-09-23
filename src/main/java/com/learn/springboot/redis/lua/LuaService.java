package com.learn.springboot.redis.lua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author: zhenghailong
 * @date: 2019/9/23 17:27
 * @modified By:
 * @description:
 */
@Component
public class LuaService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void luaParams(String key1,String key2,String value1,String value2){
        String lua = "redis.call('set',KEYS[1],ARGV[1]) redis.call('set',KEYS[2],ARGV[2]) " +
                "local str1 = redis.call('get',KEYS[1]) local str2 = redis.call('get',KEYS[2]) " +
                "if str1 == str2 then return 1 end return 0";

        DefaultRedisScript<Long> rs = new DefaultRedisScript<>();
        // 设置脚本
        rs.setScriptText(lua);
        // 定义返回类型。注意：如果没有这个定义，spring不会返回结果
        rs.setResultType(Long.class);

        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();

        ArrayList<String> keyList = new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);

        Long result = (Long)redisTemplate.execute(rs, stringSerializer, stringSerializer, keyList,value1,value2);

        System.out.println(result);
    }

    public void luaStr(){
        DefaultRedisScript<String> rs = new DefaultRedisScript<>();
        // 设置脚本
        rs.setScriptText("return 'Hello redis'");
        // 定义返回类型。注意：如果没有这个定义，spring不会返回结果
        rs.setResultType(String.class);

        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();

        String result = (String)redisTemplate.execute(rs, stringSerializer, stringSerializer, null);

        System.out.println(result);
    }
}
