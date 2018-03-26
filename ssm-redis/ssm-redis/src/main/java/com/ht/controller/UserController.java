package com.ht.controller;

import com.ht.bean.User;
import com.ht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("one/{id}")
    public void one(@PathVariable int id) {
        System.out.println("kkkkkkkk:"+id);
        User user = (User)userService.queryById(id);
        System.out.println("ni hao  :"+user);
    }

    @RequestMapping("/two")
    public void two() {
        System.out.println("jjjjjjj");
    }
}
