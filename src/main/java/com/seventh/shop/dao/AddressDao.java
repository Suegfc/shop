package com.seventh.shop.dao;

import com.seventh.shop.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressDao extends JpaRepository<Address,Integer> {

    @Modifying
    @Query(value = "update readdress a set a.detype = 0",nativeQuery = true)
    public int updataAddress();

    @Query(value = "select * from  readdress where uid = :uid order by detype desc",nativeQuery = true)
    public List<Address> selectByUid(@Param("uid") String uid);

    public Address findById(int id);

    public void deleteById(int id);

}
