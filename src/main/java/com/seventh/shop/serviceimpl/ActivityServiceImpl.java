package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.ActivityDao;
import com.seventh.shop.domain.Activity;
import com.seventh.shop.service.ActivityService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public Result<List<Map<String, Object>>> findAllActivityTitle(Integer id) {
        return activityDao.findAllActivityTitle(id) != null ? Result.success(activityDao.findAllActivityTitle(id)) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result<Map<String, Object>> findActivityInfo(Integer id) {
        Result<Map<String, Object>> result = new Result<>();
        Map<String, Object> activityInfo = activityDao.findActivityInfo(id);
        System.out.println(activityInfo.get("price"));
        if (activityInfo != null) {
            int price;
            int discount;
            double newPrice;
            if (activityInfo.get("price") != null) {
                price = Integer.valueOf(String.valueOf(activityInfo.get("price")));
                discount = (int) activityInfo.get("discount");
                newPrice = (double) (price * discount) / 10;
                result.setOther(newPrice);
            }
            result.setMsg("success");
            result.setData(activityInfo);
            result.setCode(0);
        }

        return result;
    }

}
