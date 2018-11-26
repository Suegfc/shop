package com.seventh.shop.dao;

import com.seventh.shop.domain.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderCartDao extends JpaRepository<OrderCart, Integer> {
    public OrderCart findByCustomerIdAndProductId(int customerId, int productId);

    @Modifying
    @Query(nativeQuery = true, value = "insert into order_cart VALUES(null,?1,?2,?3,0,NOW(),NOW())")
    public int insertToCar(int customerId, int productId, int productAmount);

    @Modifying
    @Query(nativeQuery = true,value = "update order_cart set product_amount=product_amount+?3 where customer_id=?1 and product_id=?2")
    public int updateCartNum(int customerId, int productId, int productAmount);
}

