package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.ActivityDao;
import com.seventh.shop.domain.Activity;
import com.seventh.shop.service.ActivityService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gfc
 * 2018年11月23日 下午 8:05
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public Result<Activity> addActivity(Activity activity) {
        return activityDao.save(activity) != null ? Result.success(activityDao.save(activity)) : Result.error(CodeMsg.ERROR);
    }
}
