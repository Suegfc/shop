package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.shopTypeDao;
import com.seventh.shop.service.shopTypeService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.seventh.shop.vo.Result.success;

@Service
public class shopTypeServiceImpl implements shopTypeService {
    @Autowired
    private shopTypeDao dao;
    @Override
    public Result findAll() {
        return Result.success(dao.findAll());
    }
}
