package com.seventh.shop.service;

import com.seventh.shop.domain.User;

public interface LoginAndRegService {
    public User saveUser(User user);
    public User loginUser(String username,String password);
    public boolean isLogin(String token);
}
