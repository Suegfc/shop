package com.seventh.shop.service;

import com.seventh.shop.domain.Address;
import com.seventh.shop.vo.Result;

public interface AddressService {
    //添加/修改收货地址
    public Result sava(Address address);

    //查询所有收货地址
    public Result selectAllById(String uid);

}
