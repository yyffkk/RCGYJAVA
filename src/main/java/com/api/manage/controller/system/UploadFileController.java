package com.api.manage.controller.system;

import com.api.manage.service.system.UploadFileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 导入Excel文件
 */
@RestController
@RequestMapping("manage/uploadFile")
public class UploadFileController {
    @Resource
    UploadFileService uploadFileService;


    /**
     * 导入房屋信息（type 必须为4.未售）
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadEstateFile")
    public Map<String,Object> UploadEstateFile(MultipartFile file){
        return uploadFileService.UploadEstateFile(file);
    }
}
