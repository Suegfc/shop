package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.RulesDao;
import com.seventh.shop.domain.Rules;
import com.seventh.shop.service.RulesService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gfc
 * 2018年11月23日 下午 8:29
 */
@Service
public class RulesServiceImpl implements RulesService {
    @Autowired
    private RulesDao dao;

    @Override
    public Result<List<Rules>> addRules(String[] rules, int aid) {
        List<Rules> rulesList = new ArrayList<>();
        if (rules != null) {
            for (int i = 0; i < rules.length; i++) {
                rulesList.add(new Rules(aid, rules[i]));
            }
        }
        return dao.saveAll(rulesList) != null ? Result.success(dao.saveAll(rulesList)) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result<List<Rules>> findAll(int aid) {
        return dao.findAllByAid(aid) != null ? Result.success(dao.findAllByAid(aid)) : Result.error(CodeMsg.ERROR);
    }
}
