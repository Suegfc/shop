package com.seventh.shop.dao;

import com.seventh.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月25日 上午 8:38
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query(nativeQuery = true, value = "SELECT id,proName FROM product WHERE shopid = ?")
    List<Map<String,Object>> findProductNameByShopId(@Param("id") Integer id);

    //添加或修改商品
    @Override
    @Transactional
    Product save(Product product);

    //根据shopid查询所有商品
    @Query(nativeQuery = true, value = "select * from product left outer join proimage on product.id = proimage.pid where shopid = ?")
    List<Product> findByShopId(@Param("shopid") Integer shopid);

    //根据shopid和tid查询商品
    @Query(nativeQuery = true, value = "select * from product left outer join proimage on product.id = proimage.pid where shopid = ? and tid = ?")
    List<Product> findByShopidAndTid(@Param("shopid") Integer shopid, @Param("tid") Integer tid);

    //根据商品id删除商品
    @Override
    @Transactional
    void deleteById(Integer integer);

    //根据商品id修改商品类型
    @Modifying
    @Transactional
    @Query(value = "update product set tid = ? where id = ?", nativeQuery = true)
    int updateProductTypeById(@Param("id") Integer id, @Param("tid") Integer tid);

}
