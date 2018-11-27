package com.seventh.shop.service;

import com.seventh.shop.domain.Type;
import com.seventh.shop.vo.Result;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:32
 */
public interface TypeService {
    Result<List<Type>> findAllType();
}
