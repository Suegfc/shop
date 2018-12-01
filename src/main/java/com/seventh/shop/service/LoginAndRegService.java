package com.seventh.shop.service;

import com.seventh.shop.domain.User;

public interface LoginAndRegService {
    User saveUser(User user);

    User loginUser(String username, String password);

    boolean isLogin(String token);
}
