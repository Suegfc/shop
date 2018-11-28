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

    //添加
    @Override
    Product save(Product product);

    //根据shopid查询所有商品
    @Query(nativeQuery = true, value = "select * from product left outer join proimage on product.id = proimage.pid where shopid = ?")
    List<Product> findByShopId(@Param("shopid") Integer shopid);

    //根据shopid和tid查询商品
    List<Product> findAllByShopidAndTid(@Param("shopid") Integer shopid, @Param("tid") Integer tid);

    //根据shopid删除商品
    int deleteByShopid(Integer shopid);
}
