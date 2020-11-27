package com.imlty.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadPicUtils {
    public static Map<String, String> upload(MultipartFile multipartFile, HttpServletRequest request) {

        //1.判断接收到的上传文件是否为空
        if (multipartFile.isEmpty()){
            throw new RuntimeException();
        }
        //2.获取项目的部署路径
        String realPath = request.getServletContext().getRealPath("/");
        String path = realPath.substring(0, realPath.indexOf("ssm-web"));

        //3.获取源文件名
        String originalFilename = multipartFile.getOriginalFilename();

        //4.生成一个新文件名
        assert originalFilename != null;
        String newName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.文件上传
        String uploadPath = path + "\\upload";

        File file = new File(uploadPath, newName);

        //如果目录不存在就创建目录
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
            System.out.println("创建目录在 "+ file);
        }

        //上传图片
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String LOCAL_URL = "http://localhost:8080/upload/";

        //6.将文件名和路径返回并响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName",newName);
        map.put("filePath",LOCAL_URL+newName);

        return map;
    }
}
