package com.ht.service;

import com.ht.bean.User;
import com.ht.common.BaseService;
import com.ht.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;
    public List queryAll() {
        return null;
    }

    public Object queryById(Serializable id) {

        ValueOperations valueOperations = redisTemplate.opsForValue();
        User user = (User)valueOperations.get("user-"+ id);
        if(user != null){
            System.out.println("hhhhhhhhhhhhh");
            return user;
        }else{
            User users = userDao.queryById(id);
            if(users != null){
                System.out.println("mmmmmmmmmmmmmmmmmmmmm");
                valueOperations.set("user-"+id,users);
            }
            return userDao.queryById(id);
        }

    }

    public void add(Object o) {

    }

    public void update(Object o) {

    }

    public void deleteById(Serializable id) {

    }

    public int countByCriteria(Object o) {
        return 0;
    }
}

