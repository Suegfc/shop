package com.seventh.shop.controller;

import com.seventh.shop.domain.Activity;
import com.seventh.shop.service.ActivityService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gfc
 * 2018年11月23日 下午 8:08
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityService service;

    @PostMapping("/api/v1/activity")
    public Result<Activity> addActivity(Activity activity) {

        return service.addActivity(activity);
    }
}
