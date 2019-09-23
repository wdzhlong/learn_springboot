package com.learn.springboot;

import com.learn.springboot.mybatis.entity.User;
import com.learn.springboot.redis.lua.LuaService;
import com.learn.springboot.redis.pipline.PiplineService;
import com.learn.springboot.redis.util.RedisUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RedisTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PiplineService piplineService;

    @Autowired
    private LuaService luaService;

    @Test
    public void contextLoads() {
        /**
         * 不是在同一个连接下完成的
         */
        User user = new User();
        user.setUserName("name");
        boolean b = redisUtil.set("a", user);
        System.out.println(b);
        User user1 = (User)redisUtil.get("a");
        System.out.println(user.getUserName());
    }

    /**
     * BoundXXXOperations接口
     */
    @Test
    public void boundKey(){
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps("string");
        System.out.println(boundValueOperations.toString());
    }

    /**
     * RedisCallback作用是让RedisTemplate进行回调，能过它可以在同一条连接下执行多个redis命令
     * 接口比较底层，需要处理内容较多，可读性较差
     * 建议尽量不选择使用
     */
    @Test
    public void useRedisCallback(){
        Object execute = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set("key1".getBytes(), "key1".getBytes());
                redisConnection.hSet("hash".getBytes(), "field1".getBytes(), "f1value".getBytes());
                return null;
            }
        });
        System.out.println(execute);
    }

    /**
     * 相较于RedisCallback推荐使用SessionCallback
     */
    @Test
    public void useSessionCallback(){
        Object execute = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                ro.opsForValue().set("key2","key2");
                ro.opsForHash().put("hash","field2","f2value");
                return null;
            }
        });
        System.out.println(execute);
    }

    @Test
    public void pipline(){
        piplineService.pipline();
    }

    @Test
    public void lua(){
        luaService.luaStr();
        luaService.luaParams("b","c","b","b");
    }
}
