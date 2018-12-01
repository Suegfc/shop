package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.AdvertisementDao;
import com.seventh.shop.domain.Advertisement;
import com.seventh.shop.service.AdvertisementService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gfc
 * 2018年12月01日 下午 2:12
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementDao advertisementDao;

    @Override
    public Result addAdvertisement(Advertisement advertisement) {

        return advertisementDao.save(advertisement) != null ? Result.success(advertisementDao.save(advertisement)) : Result.error(CodeMsg.ERROR);
    }
}
