package com.api.app.controller.upload;

import com.api.app.service.upload.AppUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app 上传文件资源
 */
@RestController
@RequestMapping("app/upload")
public class AppUploadController {
    @Resource
    AppUploadService appUploadService;

    @PostMapping("/appHeadSculpture")
    public Map<String,Object> appHeadSculpture(MultipartFile file){
        return appUploadService.appHeadSculpture(file);
    }

}
