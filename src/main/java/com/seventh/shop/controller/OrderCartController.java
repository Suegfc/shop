package com.seventh.shop.controller;

import com.seventh.shop.domain.CartDetail;
import com.seventh.shop.service.OrderCartService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * @author cylyc
 *
 */
@RestController
public class OrderCartController {
    @Autowired
    OrderCartService orderCartService;

    @PostMapping("OrderCar")//向购物车中添加
    public CodeMsg addToCar(int productId, int customerId, int productAmount) {
        if (orderCartService.addToCar(productId, customerId, productAmount)) {
            return CodeMsg.SUCCESS;
        }
        return CodeMsg.ERROR;
    }

    @DeleteMapping("OrderCar")//删除
    public CodeMsg deleteCartItem(int customerId, int productId) {
        if (orderCartService.deleteCartItem(customerId, productId)) {
            return CodeMsg.SUCCESS;
        }
        return CodeMsg.ERROR;
    }

    @GetMapping("OrderCar")//查询购物车中所有的商品
    public Result<List<CartDetail>> getCartList(int customerId) {
        List<CartDetail> cartList = orderCartService.getCartList(customerId);
        return Result.success(cartList);
    }

}
