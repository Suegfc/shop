package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.OrderCartDao;
import com.seventh.shop.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCartServiceImpl implements OrderCartService {
    @Autowired
    OrderCartDao cartDao;
//    @Autowired
//    CartDetail cartDetail;

    //确定购物车表中是否已经存在该商品
    private boolean isExit(int customerId, int productId) {
        return cartDao.findByCustomerIdAndProductId(customerId, productId) != null;
    }

    @Override
    //添加
    public boolean addToCar(int productId, int customerId, int productAmount) {
        int i;
        if (isExit(productId, customerId)) {
            i = cartDao.updateCartNum(customerId, productId, productAmount);
        } else {
            i = cartDao.insertToCar(customerId, productId, productAmount);
        }
        return i > 0;
    }

    @Override
    public boolean deleteCartItem(int productId, int customerId) {
        int i = 0;
        if (isExit(productId, customerId)) {
            i = cartDao.deleteByCustomerIdAndProductId(customerId, productId);
        } else {
            i = cartDao.deleteByCustomerIdAndProductId(customerId, productId);
        }
        return i > 0;

    }

//    @Override
//    public List<CartDetail> getCartList(int customerId) {
//
//        return null;
//    }
}
