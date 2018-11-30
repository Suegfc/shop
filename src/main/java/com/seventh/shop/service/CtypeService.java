package com.seventh.shop.service;

import com.seventh.shop.domain.Ctype;
import com.seventh.shop.vo.Result;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:32
 */
public interface CtypeService {
    Result<List<Ctype>> findAllCtypeById(int id);
}
