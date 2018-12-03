package com.seventh.shop.controller;

import com.seventh.shop.domain.User;
import com.seventh.shop.service.UserService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    //根据用户名密码查询用户信息
    @GetMapping("/api/v1/user")
    public Result<User> selectUser(User user) {

        return Result.success(service.selectUser(user));
    }

    //修改个人密码
    @PostMapping("/api/v1/password")
    public Result<User> updatePassWord(String newpassword, String oldpassword, HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        if (user != null) {
            if (service.selectUser(new User(user.getUsername(), oldpassword)) != null) {

                return service.updateUser(new User(user.getUsername(), newpassword));
            } else {
                return Result.error(CodeMsg.ERROR);
            }
        } else {
            return Result.error(CodeMsg.ERROR);
        }
    }

    @GetMapping("/api/v1/userinfo")
    public Result<User> userInfo(HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        if (user != null) {

            return Result.success(user);
        }
        return Result.error(CodeMsg.ERROR);
    }

    @PostMapping("/api/v1/myCollection")
    public Result conllection(HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        if (user != null) {
            return service.myConllection(user.getId() + "");
        }
        return Result.error(CodeMsg.ERROR);
    }
}
