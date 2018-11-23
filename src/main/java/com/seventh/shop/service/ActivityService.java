package com.seventh.shop.service;

import com.seventh.shop.domain.Activity;
import com.seventh.shop.vo.Result;

/**
 * @author gfc
 * 2018年11月23日 下午 8:05
 */
public interface ActivityService {
    Result<Activity> addActivity(Activity activity);
}
