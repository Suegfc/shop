package com.seventh.shop.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order_cart")
public class OrderCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_amount")
    private int productAmount;
    private BigDecimal price;
    @Column(name = "add_time")
    private Date addTime;
    @Column(name = "modified_time")
    private Date modifiedTime;


}
