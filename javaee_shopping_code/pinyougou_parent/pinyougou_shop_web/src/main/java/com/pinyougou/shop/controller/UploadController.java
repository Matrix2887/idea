package com.pinyougou.shop.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){

        String filename = file.getOriginalFilename();
        String substring = filename.substring(filename.lastIndexOf(".") + 1);
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String uploadFile = fastDFSClient.uploadFile(file.getBytes(), substring);
            String url = FILE_SERVER_URL + uploadFile; // 拼接正确的路径
//            System.out.println(url);
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }

    }

}
