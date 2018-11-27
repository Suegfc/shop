package com.seventh.shop.service;

import com.seventh.shop.domain.Rules;
import com.seventh.shop.vo.Result;

import java.util.List;

/**
 * @author gfc
 * 2018年11月23日 下午 8:29
 */
public interface RulesService {
    /**
     * 添加打折活动的规则
     *
     * @param rules 活动规则名称字符串数组
     * @param aid   对应活动的唯一id
     * @return 返回restful接口
     */
    Result<List<Rules>> addRules(String[] rules, int aid);

    Result<List<Rules>> findAll(int aid);
}
