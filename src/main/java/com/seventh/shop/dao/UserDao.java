package com.seventh.shop.dao;

import com.seventh.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


/**
 * @author gfc
 * 2018年11月23日 上午 10:26
 */
public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value = "select * from `user` u where u.username = :username and u.password=:password", nativeQuery = true)
    User findUser(@Param("username")  String username, @Param("password") String password);

    @Modifying
    @Query(value = "update user u  set u.password = :password where u.username = :username", nativeQuery = true)
    int updateUser(@Param("username") String username, @Param("password") String password);


    @Query(value = "select s.id,s.phone, s.shopLogo, s.shopName ,s.shopDesc  from shop s LEFT JOIN collection  c on s.id = c.shopid LEFT JOIN `user` u ON :id = c.userid",nativeQuery = true)
    List<Map<String,Object>> myConllection(@Param("id")String Id);
}
