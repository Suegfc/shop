package com.seventh.shop.service;

import com.seventh.shop.domain.Store;
import com.seventh.shop.vo.Result;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 下午 9:37
 */
public interface StoreService {
    Result<List<Store>> findAllStore();

    Result<List<Store>> findAllStoreRandom();

    Result<Store> findStoreById(int id);
}
