package com.seventh.shop.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.seventh.shop.domain.Product;
import com.seventh.shop.service.ProductService;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Result<List<Map<String, Object>>> getAllProName(Integer shopId) {
        
        return productService.findProductNameByShopId(shopId);
    }

    //上传图片
    @PostMapping("/upload")
    public Result<String> uploadFile(HttpServletResponse response, @RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException {

        //解决ie下的bug
        response.setContentType("text/html");

        String FileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();

        File file = new File("D:\\Downloads\\upload\\" + FileName);

        multipartFile.transferTo(file);

        return Result.success(FileName);
    }

    @PostMapping("/product")
    public Result<Product> addProduct(Product product, String[] filename){
        System.out.println(filename);
        return productService.addProduct(product, filename);
    }

    @GetMapping("/product")
    public Result<List<Product>> showProduct(Integer shopid, Integer tid) {
        return productService.showProduct(shopid, tid);
    }

    @DeleteMapping("/product")
    public Result deleteProduct(Integer id) {
        Result result = productService.deleteProduct(id);
        return result;
    }

    @PatchMapping("/product")
    public Result updateProductType(Integer tid ,Integer id) {
        return productService.updateProductType(tid, id);
    }
}
