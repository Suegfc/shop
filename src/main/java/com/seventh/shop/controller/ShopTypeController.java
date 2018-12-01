package com.seventh.shop.controller;

import com.seventh.shop.service.shopTypeService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopTypeController {
    @Autowired
    private shopTypeService service;

    @GetMapping("api/v1/shopType")
    public Result findAll(){

        return service.findAll();
    }

}
