package com.seventh.shop.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.seventh.shop.domain.Address;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.AddressService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class AddressController {
    //添加or修改地址
    @Autowired
    private AddressService service;

    @PostMapping(path = "/api/v1/address")
    public Result save(Address address,HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        address.setUid(user.getId());
        return service.sava(address);
    }

    //查询所有收货地址
    @GetMapping(path = "/api/v1/address")
    public Result select(HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        return service.selectAllById(user.getId());
    }

    //查询单个地址信息
    @GetMapping(path = "/api/v1/getadd")
    public Result selectById(String id) {

        return service.selectById(Integer.valueOf(id));
    }

    //删除某个地址
    @DeleteMapping(path = "/api/v1/address")
    public Result deleteById(String id) {
        System.out.print("111111111111111111111");
        return service.deleteById(Integer.valueOf(id));
    }
}
