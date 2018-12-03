package com.seventh.shop.service;

import com.seventh.shop.domain.Store;
import com.seventh.shop.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月27日 下午 9:37
 */
public interface StoreService {
    Result<List<Store>> findAllStore();

    Result addStore(Store store);

    Result<List<Store>> findAllStoreRandom();

    Result<Store> findStoreById(int id);

    int findId(int uid);

}
