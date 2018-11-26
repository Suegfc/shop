package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.ProductDao;
import com.seventh.shop.domain.Product;
import com.seventh.shop.service.ProductService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月25日 上午 8:48
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;

    @Override
    public Result<List<Map<String, Object>>> findProductNameByShopId(Integer shopId) {
        return dao.findProductNameByShopId(shopId) != null ? Result.success(dao.findProductNameByShopId(shopId)) : Result.error(CodeMsg.ERROR);
    }
}
