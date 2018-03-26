package com.gs.service.impl;

import com.gs.bean.User;
import com.gs.common.Pager;
import com.gs.dao.UserDAO;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisTemplate redisTemplate;
    public void save(Object obj) {

    }

    public void remove(Object obj) {

    }

    public void removeById(Long id) {

    }

    public void update(Object obj) {

    }

    public Object getById(int id) {
       /* User user = new User();
        System.out.println("lai le  :"+id);
        jedisCluster.hmget("user-"+id,"user");
        List<String> list = jedisCluster.hmget("user-"+id,"id","username","money");
        System.out.println("list :"+list.size());
        System.out.println(list);
        user.setId(Integer.valueOf(list.get(0)));
        user.setUsername(list.get(1));
        user.setMoney(Integer.valueOf(list.get(2)));
        if(user != null){
            System.out.println("从缓存中拿数据");
            return user;
        } else {
            System.out.println("从数据库中拿数据");
            User use = (User)userDAO.getById(id);
            if (use != null) {
                Map<String, String> hash = new HashMap<String, String>();
                hash.put("id", use.getId()+"");
                hash.put("username", use.getUsername());
                hash.put("money", use.getMoney()+"");
                // 添加多条
                jedisCluster.hmset("user-"+id,hash);
            }
            return use;
        }*/

        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        User user = valueOperations.get("user-" + id);
        System.out.println("id   :"+id);
        if (user != null) {
            System.out.println("从缓存中拿数据");
            return user;
        } else {
            System.out.println("从数据库中拿数据");
            Object obj = userDAO.getById(id);
            if (obj != null) {
                valueOperations.set("user-" + id, (User) obj);
            }
            return obj;
        }
    }

    public List<Object> listAll() {
        return null;
    }

    public Pager listPager(int pageNo, int pageSize) {
        return null;
    }

    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        return null;
    }
}
