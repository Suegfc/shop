package com.seventh.shop.controller;

import com.seventh.shop.utils.OSSUtil;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ShopLogoController {

    @PostMapping("/api/v1/logo")
    public Result shopLogo(@RequestParam("file") MultipartFile files, HttpServletResponse resp) throws IOException {
        // 解决ie浏览器下的Bug
        resp.setContentType("text/html");
        String filename = UUID.randomUUID().toString().substring(0, 10) + files.getOriginalFilename();
        if (!files.isEmpty()) {
            String path = OSSUtil.fileUp(filename, files.getBytes());
            return Result.success(path);
        } else {
            return Result.error(CodeMsg.ERROR);
        }
    }
}
