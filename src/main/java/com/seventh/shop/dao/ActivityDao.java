package com.seventh.shop.dao;

import com.seventh.shop.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月23日 下午 7:57
 */
public interface ActivityDao extends JpaRepository<Activity, Integer> {

    /**
     *
     * @param id
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT id,title FROM activity WHERE pid = (SELECT id FROM product WHERE shopid=?)")
    List<Map<String, Object>> findAllActivityTitle(@Param("id") Integer id);

    /**
     *
     * @param id
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT price,discount,starttime,endtime FROM product,activity WHERE product.`id`=pid AND pid = ?")
    Map<String, Object> findActivityInfo(@Param("id") Integer id);
}
