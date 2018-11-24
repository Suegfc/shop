package com.seventh.shop.service;

import com.seventh.shop.domain.Activity;
import com.seventh.shop.vo.Result;

/**
 * @author gfc
 * 2018年11月23日 下午 8:05
 */
public interface ActivityService {
    /**
     * 添加商品打折活动
     * @param activity 活动Activity对象
     * @return 泛型为Activity的restful接口
     */
    Result<Activity> addActivity(Activity activity);
}
