package com.seventh.shop.controller;

import com.seventh.shop.domain.Rules;
import com.seventh.shop.service.RulesService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gfc
 * 2018年11月23日 下午 8:31
 */
@RestController
public class RulesController {
    @Autowired
    private RulesService service;

    @PostMapping("/api/v1/rules")
    public Result<List<Rules>> addRules(String[] rules, int aid) {

        return service.addRules(rules, aid);
    }
}
