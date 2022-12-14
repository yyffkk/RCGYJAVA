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
     * 导入楼栋信息
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadBuildingFile")
    public Map<String,Object> UploadBuildingFile(MultipartFile file){
        return uploadFileService.UploadBuildingFile(file);
    }

    /**
     * 导入单元信息
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadBuildingUnitFile")
    public Map<String,Object> UploadBuildingUnitFile(MultipartFile file){
        return uploadFileService.UploadBuildingUnitFile(file);
    }

    /**
     * 导入房屋信息（status 必须为4.未售）
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadEstateFile")
    public Map<String,Object> UploadEstateFile(MultipartFile file){
        return uploadFileService.UploadEstateFile(file);
    }

    /**
     * 导入服务浏览信息
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadServiceBrowsingFile")
    public Map<String,Object> UploadServiceBrowsingFile(MultipartFile file){
        return uploadFileService.UploadServiceBrowsingFile(file);
    }

    /**
     * 导入钥匙信息
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadKeyFile")
    public Map<String,Object> UploadKeyFile(MultipartFile file){
        return uploadFileService.UploadKeyFile(file);
    }

    /**
     * 导入绿化区域信息
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadGreenAreaFile")
    public Map<String,Object> UploadGreenAreaFile(MultipartFile file){
        return uploadFileService.UploadGreenAreaFile(file);
    }

    /**
     * 导入欠费记录（导入日常缴费信息）
     * @param file 上传Excel文件
     * @return map
     */
    @PostMapping("/UploadDailyPaymentFile")
    public Map<String,Object> UploadDailyPaymentFile(MultipartFile file){
        return uploadFileService.UploadDailyPaymentFile(file);
    }


}
