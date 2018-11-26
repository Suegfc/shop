package com.seventh.shop.service;

import com.seventh.shop.domain.Activity;
import com.seventh.shop.vo.Result;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据店铺id查询所有打折活动
     * @param id
     * @return
     */
    Result<List<Map<String,Object>>> findAllActivityTitle(Integer id);

    /**
     * 查询打折信息
     * @param id
     * @return
     */
    Result<Map<String,Object>> findActivityInfo(Integer id);
}
