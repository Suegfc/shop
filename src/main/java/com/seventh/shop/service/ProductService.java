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

    /**
     * 添加商品
     * @param product  包含了商品各种信息的实体类
     * @param filename 商品图片名
     * @return 返回添加成功的商品对象
     */
    Result<Product> addProduct(Product product, String[] filename);

    /**
     * 根据商铺展示商铺内的所有商品
     * @param shopid 商铺id
     * @param tid 根据商品类型展示商品
     * @return
     */
    Result<List<Product>> showProduct(Integer shopid,Integer tid);

    /**
     * 根据商品id删除商品
     * @param id 商品id
     * @return 返回删除成功的信息
     */
    Result deleteProduct(Integer id);

    Result updateProductType(Integer tid, Integer id);
}
