package com.seventh.shop.serviceimpl;

import com.seventh.shop.dao.ProductDao;
import com.seventh.shop.dao.ProimageDao;
import com.seventh.shop.domain.Product;
import com.seventh.shop.domain.Proimage;
import com.seventh.shop.service.ProductService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gfc
 * 2018年11月25日 上午 8:48
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProimageDao proimageDao;

    @Override
    public Result<List<Map<String, Object>>> findProductNameByShopId(Integer shopId) {
        return productDao.findProductNameByShopId(shopId) != null ? Result.success(productDao.findProductNameByShopId(shopId)) : Result.error(CodeMsg.ERROR);
    }

    /**
     * 添加商品
     * @param product 前端传递过来的商品参数
     * @param filename 前端传递过来的文件名
     * @return 成功返回一个商品对象，失败则返回错误信息和错误状态码
     */
    @Override
    public Result<Product> addProduct(Product product, String[] filename) {
        productDao.save(product);

        if (filename != null) {
            List<Proimage> list = new ArrayList<Proimage>();

            for (String imgurl : filename) {
                Proimage proimage = new Proimage();
                proimage.setImgurl(imgurl);
                proimage.setPid(product.getId());
                list.add(proimage);
            }

            proimageDao.saveAll(list);
            if (proimageDao.saveAll(list)== null) {
                return Result.error(CodeMsg.ERROR);
            }
        }

        return productDao.save(product) != null ? Result.success(productDao.save(product)) : Result.error((CodeMsg.ERROR));
    }

    /**
     * 根据商品种类不同，展示商品
     * @param tid 前端传递过来的商品种类id，如果为空，则展示全部商品
     * @return 成功返回查询出的所有商品集合，失败则返回错误信息和错误状态码
     */
    @Override
    public Result<List<Product>> showProduct(Integer shopid,Integer tid) {
        if (tid == null) {
            List<Product> products = productDao.findByShopId(shopid);
            return products != null ? Result.success(productDao.findByShopId(shopid)) :Result.error(CodeMsg.ERROR);
        } else  {
            List<Product> products = productDao.findByShopidAndTid(shopid, tid);
            return products != null ? Result.success(productDao.findByShopidAndTid(shopid, tid)) :Result.error(CodeMsg.ERROR);
        }
    }

    /**
     * 根据商品id删除商品和图片
     * @param id 商品id
     * @return 返回删除成功信息
     */
    @Override
    public Result deleteProduct(Integer id) {
        productDao.deleteById(id);
        proimageDao.deleteByPid(id);

        return Result.error(CodeMsg.SUCCESS);
    }

    @Override
    public Result updateProductType(Integer tid, Integer id) {
        int i = productDao.updateProductTypeById(tid, id);
        return i > 0 ? Result.error(CodeMsg.SUCCESS) : Result.error(CodeMsg.ERROR);
    }
}
