package com.gs.controller;

import com.gs.bean.User;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    @ResponseBody
    public User get(@PathVariable("id") int id) {
        Object obj = userService.getById(id);
        return obj == null ? null : (User) obj;
    }

    @RequestMapping("/test")
    public void test() {

        System.out.println("ffffffffff");
    }
}
