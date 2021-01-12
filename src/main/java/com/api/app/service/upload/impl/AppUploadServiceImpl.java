package com.api.app.service.upload.impl;

import com.api.app.service.upload.AppUploadService;
import com.api.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class AppUploadServiceImpl implements AppUploadService {
    private static Map<String,Object> map = null;

    @Value("${prop.upload-app-head-sculpture}")
    private String UPLOAD_APP_HEAD_SCULPTURE;

    @Override
    public Map<String, Object> appHeadSculpture(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_HEAD_SCULPTURE);
        return map;
    }

    //上传照片
    public Map<String,Object> upload(MultipartFile file,String path){
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.upload(file, path);
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","上传成功");
        map.put("url",url);
        map.put("status",true);
        return map;
    }
}
