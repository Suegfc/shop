package com.seventh.shop.controller;

import com.seventh.shop.domain.Type;
import com.seventh.shop.service.TypeService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:44
 */
@RestController
public class TypeController {
    @Autowired
    private TypeService service;

    @GetMapping("/api/v1/types")
    public Result<List<Type>> findAllTypes() {
        return service.findAllType();
    }
}
