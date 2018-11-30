package com.seventh.shop.service;

public interface OrderCartService {
    boolean addToCar(int productId, int customerId, int productAmount);

    boolean deleteCartItem(int productId, int customerId);
}
