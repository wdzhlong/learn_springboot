package com.learn.springboot.redis.cache_annotation;

import com.learn.springboot.mybatis.dao.MybatisUserDao;
import com.learn.springboot.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author: zhenghailong
 * @date: 2019/9/23 18:03
 * @modified By:
 * @description:
 */
@Service
public class CacheAnnotationService {

    @Autowired
    private MybatisUserDao userDao;

    /**
     * @CachePut：将方法结果返回放入缓存中
     * value属性：配置的缓存名称
     * key属性：spring el表达式值
     * @param user
     * @return
     */
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    public User insertUser(User user){
        userDao.insertUser(user);
        return user;
    }

    /**
     * 表示先从缓存中通过定义的键查询，如果可以查询到数据，则返回，否则执行
     * 该方法，返回数据，并且将返回结果保存到缓存中。
     * @param id
     * @return
     */
    @Cacheable(value = "redisCache", key = "'redis_user_'+#id")
    public User getUser(Integer id){
        return userDao.getUser(id);
    }

    @CachePut(value = "redisCache",condition = "#result != 'null'", key = "'redis_user_'+#result.id")
    public User updateUser(Integer id,String userName){
        User user = this.getUser(id);
        if (Objects.isNull(user)){
            return null;
        }
        user.setUserName(userName);
        return userDao.updateUser(user);
    }

    /**
     * @CacheEvict 通过定义的键移除缓存，它有一个Boolean 类型的配置项 beforelnvocation ，表
     * 示在方法之前或者之后移除缓存。因为其默认值为也lse ，所以默认为方法之后将缓存移除
     * @param id
     * @return
     */
    @CacheEvict(value = "redisCache",key = "'redis_user_'+#id",beforeInvocation = false)
    public int deleteUser(Integer id){
        return userDao.deleteUser(id);
    }
}
