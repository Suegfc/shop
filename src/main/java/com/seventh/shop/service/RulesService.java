package com.seventh.shop.service;

import com.seventh.shop.domain.Rules;
import com.seventh.shop.vo.Result;

import java.util.List;

/**
 * @author gfc
 * 2018年11月23日 下午 8:29
 */
public interface RulesService {
    Result<List<Rules>>  addRules(String[] rules,int aid);
}
