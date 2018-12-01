package com.seventh.shop.dao;

import com.seventh.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAndRegDao extends JpaRepository<User, Integer> {
    public User findByUsernameAndPassword(String username,String password);
}
