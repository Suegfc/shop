package com.seventh.shop.dao;

import com.seventh.shop.domain.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderCartDao extends JpaRepository<OrderCart, Integer> {
    OrderCart findByCustomerIdAndProductId(int customerId, int productId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into order_cart VALUES(null,?1,?2,?3,0,NOW(),NOW())")
    int insertToCar(int customerId, int productId, int productAmount);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update order_cart set product_amount=?3 where customer_id=?1 and product_id=?2")
    int updateCartNum(int customerId, int productId, int productAmount);

    @Modifying
    @Transactional
    int deleteByCustomerIdAndProductId(int customerId, int productId);
}

