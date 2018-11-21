package com.seventh.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gfc
 * 2018年11月21日 下午 8:11
 */
@RestController
public class DemoController {

    @RequestMapping(path = "/world")
    public String hello() {
        return "hello world!";
    }
}
