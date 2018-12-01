package com.seventh.shop.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.seventh.shop.dao.LoginAndRegDao;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.LoginAndRegService;
import com.seventh.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;

@Service
public class LoginAndRegServiceImpl implements LoginAndRegService {
    @Autowired
    LoginAndRegDao larDao;
    @Autowired
    UserService userService;

    @Override
    public User saveUser(User user) {
        return larDao.save(user);

    }

    @Override
    public User loginUser(String username, String password) {
        return larDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean isLogin(String token) {
        String decode = URLDecoder.decode(token);
        System.out.println(decode);
        User user = JSON.parseObject(decode, User.class);
        System.out.println(user);

        if (null == userService.selectUser(user)){
            return false;
        }
        return true;
    }
}
