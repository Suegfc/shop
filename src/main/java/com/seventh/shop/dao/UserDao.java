package com.seventh.shop.dao;

import com.seventh.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @author gfc
 * 2018年11月23日 上午 10:26
 */
public interface UserDao extends JpaRepository<User, Integer> {

    public User findByUsernameAndPassword(String username, String password);
            
    @Modifying
    @Query(value = "update user u  set u.password = :password where u.username = :username",nativeQuery = true)
    public int updataUser(@Param("username")String username, @Param("password")String password);


}
