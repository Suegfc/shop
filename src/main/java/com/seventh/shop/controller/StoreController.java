package com.seventh.shop.controller;

import com.seventh.shop.domain.Store;
import com.seventh.shop.service.StoreService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 下午 9:37
 */
@RestController
public class StoreController {
    @Autowired
    private StoreService service;

    @GetMapping("/api/v1/stores")
    public Result<List<Store>> findAllStore() {
        return service.findAllStore();
    }

    @PostMapping("/api/v1/shop")
    public Result addShop(Store store){

        return  service.addStore(store);
    }
}
