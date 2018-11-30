package com.seventh.shop.controller;

import com.seventh.shop.service.OrderCartService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author cylyc
 *
 */
@RestController
public class OrderCartController {
    @Autowired
    OrderCartService orderCartService;

    @PostMapping("addToOrderCar")
    public Result addToCar(int productId,int customerId,int productAmount) {
        if (orderCartService.addToCar(productId,customerId,productAmount)) {
            return null;
        }
        return  null;

    }
}
