package com.seventh.shop.dao;

import com.seventh.shop.domain.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCartDao extends JpaRepository<OrderCart, Integer>{
}
