package com.seventh.shop.controller;

import com.seventh.shop.domain.Ctype;
import com.seventh.shop.service.CtypeService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gfc
 * 2018年11月27日 上午 10:43
 */
@RestController
public class CtypeController {
    @Autowired
    private CtypeService service;

    @GetMapping("/api/v1/ctypes")
    public Result<List<Ctype>> findAllCtypes(int id) {
        return service.findAllCtypeById(id);
    }
}
