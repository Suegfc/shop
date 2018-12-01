package com.seventh.shop.controller;

import com.seventh.shop.domain.Address;
import com.seventh.shop.service.AddressService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController {
    @Autowired
    private AddressService service;
    @PostMapping(path = "/api/v1/address")
    public Result sava(Address address){


            return service.sava(address);
    }


    @GetMapping (path = "/api/v1/address")
    public Result select(String uid){

        return service.selectAllById(uid);
    }
}
