package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.StoreDao;
import com.seventh.shop.domain.Store;
import com.seventh.shop.service.StoreService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 下午 9:37
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreDao storeDao;

    @Override
    public Result<List<Store>> findAllStore() {
        return storeDao.findAll() != null ? Result.success(storeDao.findAll()) : Result.error(CodeMsg.ERROR);
    }
}
