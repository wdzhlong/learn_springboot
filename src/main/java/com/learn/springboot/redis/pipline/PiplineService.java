package com.learn.springboot.redis.pipline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;

/**
 * @author: zhenghailong
 * @date: 2019/9/23 16:36
 * @modified By:
 * @description:
 */
@Service
public class PiplineService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 经测试：非pipline模式下使用了21432豪秒，pipline模式下只用了1000多毫秒
     */
    public void pipline() {
        long l = System.currentTimeMillis();
        redisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    redisOperations.opsForValue().set("pipline_" + i, "value_" + i);
                    Object o = redisOperations.opsForValue().get("pipline_" + i);
                    if (i % 10000 == 0) {
                        System.out.println("命令只是进入队列，所有值为空" + o);
                    }
                }
                return null;
            }
        });
        long l1 = System.currentTimeMillis() - l;
        System.out.println(l1);
    }
}
