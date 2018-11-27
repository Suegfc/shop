package com.seventh.shop.dao;

import com.seventh.shop.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gfc
 * 2018年11月27日 下午 9:35
 */
public interface StoreDao extends JpaRepository<Store,Integer> {
}
