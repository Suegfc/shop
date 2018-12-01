package com.seventh.shop.controller;

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
        String fileName = UUID.randomUUID().toString() + files.getOriginalFilename();
        File file = new File("D:\\file\\" + fileName);

        files.transferTo(file);
      Result result =  Result.success(fileName);
        // 将文件的名字或者文件的路径在返回给前端，前端获取到之后保存到隐藏表单域中，和其他的文本第二次提交的时候一起保存到数据库
        return result;

    }
}
