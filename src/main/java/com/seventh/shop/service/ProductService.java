package com.seventh.shop.service;

import com.seventh.shop.domain.Product;
import com.seventh.shop.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月25日 上午 8:48
 */
public interface ProductService {
    /**
     * 添加活动规则是查询商家对应的商品
     * @param shopId 商家店铺id
     * @return 所有商品信息
     */
    Result<List<Map<String,Object>>> findProductNameByShopId(Integer shopId);

    Result<Product> addProduct(Product product, String[] filename);

    Result<List<Product>> showProduct(Integer shopid,Integer tid);
}
