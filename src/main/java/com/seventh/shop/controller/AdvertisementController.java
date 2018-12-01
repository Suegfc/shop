package com.seventh.shop.controller;

import com.seventh.shop.domain.Advertisement;
import com.seventh.shop.service.AdvertisementService;
import com.seventh.shop.vo.CodeMsg;
import com.seventh.shop.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author gfc
 * 2018年12月01日 下午 4:15
 */
@RestController
public class AdvertisementController {
    @Autowired
    private AdvertisementService service;

    @PostMapping("/api/v1/img")
    public Result<String> uploadImg(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        String path = "D://picture//";
        String filename = UUID.randomUUID().toString().substring(0, 10) + multipartFile.getOriginalFilename();
        File file = new File(path + filename);
        multipartFile.transferTo(file);

        return multipartFile != null? Result.success(filename) : Result.error(CodeMsg.ERROR);
    }

    @PostMapping("/api/v1/advertisement")
    public Result<Advertisement> addAdvertisement(Advertisement advertisement) {

        return service.addAdvertisement(advertisement);
    }
}
