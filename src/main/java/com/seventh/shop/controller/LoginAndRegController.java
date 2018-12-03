package com.seventh.shop.controller;

import com.alibaba.fastjson.JSON;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.LoginAndRegService;
import com.seventh.shop.service.StoreService;
import com.seventh.shop.utils.CookieUtils;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1")
public class LoginAndRegController {
    @Autowired
    LoginAndRegService larService;
    @Autowired
    StoreService service;

    @PostMapping("/userAdd")
    public Result reg(User user) {
        user.setHeadportrait("http://sueyunimages.oss-cn-beijing.aliyuncs.com/2ef27563-2touxiang.png?Expires=1575268598&OSSAccessKeyId=LTAIz5Q8ogs8vCgJ&Signature=2t1qAijWOGk15NS4c0iUD2uRIes%3D");
        if (larService.saveUser(user) != null) {
            return Result.success("注册成功");
        }
        return Result.error(CodeMsg.newError(1000, "注册失败"));
    }

    @PostMapping("/userLogin")
    public Result login(String username, String password, HttpServletRequest request) {
        User user = larService.loginUser(username, password);
        if (user != null) {
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("user", user);
            servletContext.setAttribute("sid", service.findId(user.getId()));
            return Result.success("登陆成功");
        }
        return Result.error(CodeMsg.ERROR);
    }

    //下面方法不用
    @PostMapping("/testCookie")
    public Result testcookie(HttpServletRequest request, HttpSession session) {
        if (larService.isLogin((String) request.getParameter("token"))) {
            return Result.success("验证成功");
        }
        return Result.error(CodeMsg.ERROR);
    }
}
