package com.seventh.shop.service;

import com.seventh.shop.domain.CartDetail;

import java.util.List;

public interface OrderCartService {
    public boolean addToCar(int productId,int customerId,int productAmount);

    public boolean deleteCartItem(int productId,int customerId);

    public List<CartDetail> getCartList(int customerId);
}
