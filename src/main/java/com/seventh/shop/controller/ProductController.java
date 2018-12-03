package com.seventh.shop.controller;

import com.seventh.shop.domain.Product;
import com.seventh.shop.domain.User;
import com.seventh.shop.service.ProductService;
import com.seventh.shop.utils.OSSUtil;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author gfc
 * 2018年11月25日 上午 8:59
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Result<List<Map<String, Object>>> getAllProName(HttpServletRequest request) {

        int sid = (int) request.getServletContext().getAttribute("sid");
        return productService.findProductNameByShopId(sid);
    }

    @GetMapping("/allt")
    public Result<List<Map<String, Object>>> getAllProduct(Integer tid) {

        return productService.findAllProduct(tid);
    }

    @GetMapping("/allc")
    public Result<List<Map<String, Object>>> getAllProByCid(Integer cid) {

        return productService.findAllProductByCid(cid);
    }

    //上传图片
    @PostMapping("/upload")
    public Result<String> uploadFile(HttpServletResponse response, @RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException {

        //解决ie下的bug
        response.setContentType("text/html");
        String filename = UUID.randomUUID().toString().substring(0, 10) + multipartFile.getOriginalFilename();
        if (!multipartFile.isEmpty()) {
            String path = OSSUtil.fileUp(filename, multipartFile.getBytes());
            return Result.success(path);
        } else {
            return Result.error(CodeMsg.ERROR);
        }
    }

    @PostMapping("/product")
    public Result<Product> addProduct(Product product, String[] filename, HttpServletRequest request) {
        if (product != null) {
            int shopId = (Integer) request.getServletContext().getAttribute("sid");
            product.setShopid(shopId);
        }
        return productService.addProduct(product, filename);
    }

    @GetMapping("/product")
    public Result<List<Product>> showProduct(Integer shopId, Integer tid, HttpServletRequest request) {
        if (shopId == null || shopId == 0) {
            shopId = (Integer) request.getServletContext().getAttribute("sid");
        }
        return productService.showProduct(shopId, tid);
    }

    @DeleteMapping("/product")
    public Result deleteProduct(Integer id) {
        Result result = productService.deleteProduct(id);
        return result;
    }

    @PatchMapping("/product")
    public Result updateProductType(Integer tid, Integer id) {
        return productService.updateProductType(tid, id);
    }

    @PostMapping("/modifyproduct")
    public Result updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/type")
    public Result findProductType() {
        return productService.findAllProductType();
    }

    @GetMapping("/onepro")
    public Result<Product> findProduct(int id) {
        return productService.findById(id);
    }

}
