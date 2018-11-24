package com.seventh.shop.domain;

import javax.persistence.*;

@Entity
@Table(name="order_cart")
public class OrderCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;
    private int customer_id;
    private int product_id;
    private int product_amount;
    private int price;
    private int add_time;
    private int modified_time;

    public OrderCart(int customer_id, int product_id, int product_amount, int price, int add_time, int modified_time) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.product_amount = product_amount;
        this.price = price;
        this.add_time = add_time;
        this.modified_time = modified_time;
    }

    public OrderCart() {
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public int getModified_time() {
        return modified_time;
    }

    public void setModified_time(int modified_time) {
        this.modified_time = modified_time;
    }
}
