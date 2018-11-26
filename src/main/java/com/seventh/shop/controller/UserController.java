package com.seventh.shop.controller;

import com.seventh.shop.domain.User;
import com.seventh.shop.service.UserService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    //根据用户名密码查询用户信息
    @GetMapping("/api/v1/user")
    public Result<User> selectUser(User user){

        return service.selectUser(user);
    }
    //修改个人密码
    @GetMapping("/api/v1/password")
    public Result<User> updatePassWord(User user){

        return service.selectUser(user);
    }
}
