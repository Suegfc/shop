package com.seventh.shop.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.ByteArrayInputStream;
import java.util.Calendar;

/**
 * @author gfc
 * 2018年12月02日 上午 11:38
 */
public class OSSUtil {
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIz5Q8ogs8vCgJ";
    private static String accessKeySecret = "AuuV5rifGr8tI7rQ8u6Q1iCrsuWcO7";

    private static String bucketName = "sueyunimages";


    //创建客户端
    private static OSS createClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    //上传文件
    public static String fileUp(String filename, byte[] data) {
        OSS client = createClient();
        client.putObject(bucketName, filename, new ByteArrayInputStream(data));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return client.generatePresignedUrl(bucketName, filename, calendar.getTime()).toString();
    }
}
