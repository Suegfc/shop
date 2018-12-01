package com.seventh.shop.dao;

import com.seventh.shop.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 下午 9:35
 */
public interface StoreDao extends JpaRepository<Store, Integer> {

    @Query(nativeQuery = true, value="SELECT COUNT(id) FROM shop")
    int findCount();

    Store findById(int id);
}
