package com.seventh.shop.controller;

import com.alibaba.fastjson.JSON;
import com.seventh.shop.constant.SystemCon;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.LoginAndRegService;
import com.seventh.shop.utils.CookieUtils;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api/v1")
public class LoginAndRegController {
    @Autowired
    LoginAndRegService larService;

    @PostMapping("userAdd")
    public Result reg(User user) {
        if (larService.saveUser(user) != null) {
            return Result.success("注册成功");
        }
        return Result.error(CodeMsg.newError(1000, "注册失败"));
    }

    @PostMapping("userLogin")
    public Result login(String username, String password, HttpSession session, HttpServletResponse response) {
        User finduser = larService.loginUser(username, password);
        if (finduser != null) {
            session.setAttribute("user",finduser);
              CookieUtils.setCK(response, SystemCon.isLogin, URLEncoder.encode(JSON.toJSONString(finduser)));
            session.setAttribute("user",finduser);
            return Result.success("登陆成功");
        }
        return Result.error(CodeMsg.ERROR);
    }

//下面方法不用
    @PostMapping("testCookie")
    public Result testcookie(HttpServletRequest request,HttpSession session) {
       if (larService.isLogin((String) request.getParameter("token")))
        return Result.success("验证成功");
        return  Result.error(CodeMsg.ERROR);
    }
}
