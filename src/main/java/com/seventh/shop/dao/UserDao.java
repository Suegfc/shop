package com.seventh.shop.dao;

import com.seventh.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gfc
 * 2018年11月23日 上午 10:26
 */
public interface UserDao extends JpaRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);


}
