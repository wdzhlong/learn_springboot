package com.learn.springboot.redis.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

/**
 * @author: zhenghailong
 * @date: 2019/9/23 16:14
 * @modified By:
 * @description:
 */
@Service
public class RedisTransactionalService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis事务的特点：
     * 就算有命令失败，队列中的其他命令也会被执行
     * 当EXEC调用后，一些命令可能执行失败，如，在一个字符串上就行加1操作。但是它之后的命令依然可以执行
     */
    public void multi(){
        redisTemplate.opsForValue().set("key1","value1");

        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                // 监控key，可以设置多个watch
                // 在事务过程中是否有修改，如果没有则执行事务，否则就取消事务
                redisOperations.watch("key1");
                // 开启事务，有exec命令执行前，全部都只是进入队列
                redisOperations.multi();

                redisOperations.opsForValue().set("key2","value2");
                // 获取值将为null,因为redis只是把命令放入队列
                Object value2 = redisOperations.opsForValue().get("key2");
                // 放弃事务
                // redisOperations.discard();

                System.out.println(value2);

                return redisOperations.exec();
            }
        });
    }
}
