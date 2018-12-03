package com.seventh.shop.service;

import com.seventh.shop.domain.Address;
import com.seventh.shop.vo.Result;

public interface AddressService {
    //添加/修改收货地址
     Result sava(Address address);
    //查询所有收货地址
     Result selectAllById(int uid);
    //查询指定地址信息
    Result selectById(int id);
    //删除指定地址
    Result deleteById(int id);



}
