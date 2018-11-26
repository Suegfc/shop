package com.seventh.shop.dao;

import com.seventh.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月25日 上午 8:38
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "SELECT id,proName FROM product WHERE shopid = ?")
    List<Map<String,Object>> findProductNameByShopId(@Param("id") Integer id);
}
