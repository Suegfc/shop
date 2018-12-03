package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.StoreDao;
import com.seventh.shop.domain.Store;
import com.seventh.shop.service.StoreService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

    @Override
    public Result addStore(Store store) {
        return storeDao.save(store) == null ? Result.error(CodeMsg.ERROR) : Result.success(storeDao.save(store));
    }

    @Override
    public Result<List<Store>> findAllStoreRandom() {
        Set<Integer> sid = new HashSet<>();
        Random random = new Random();
        int length = 5;
        for (int i = 0; i < length; i++) {
            sid.add(random.nextInt(storeDao.findCount()));
        }
        return storeDao.findAllById(sid) != null ? Result.success(storeDao.findAllById(sid)) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result<Store> findStoreById(int id) {
        return storeDao.findById(id) != null ? Result.success(storeDao.findById(id)) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public int findId(int uid) {
        return uid != 0 ? storeDao.findId(uid) : 0;
    }


}
