package com.seventh.shop.dao;

import com.seventh.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LoginAndRegDao extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
