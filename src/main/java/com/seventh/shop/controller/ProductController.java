package com.seventh.shop.controller;

import com.seventh.shop.domain.Product;
import com.seventh.shop.service.ProductService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月25日 上午 8:59
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/v1/products")
    public Result<List<Map<String, Object>>> getAllProName(Integer shopId) {
        
        return productService.findProductNameByShopId(shopId);
    }
}
