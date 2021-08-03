package com.api.butlerApp.controller.upload;

import com.api.butlerApp.service.upload.ButlerAppUploadService;
import com.api.manage.service.system.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * butlerApp 管家app上传文件资源
 */
@RestController
@RequestMapping("butlerApp/user/upload")
public class ButlerAppUploadController {
    @Resource
    ButlerAppUploadService butlerAppUploadService;
    @Resource
    UploadService uploadService;

    /**
     * 上传个人资料头像照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/butlerAppHeadSculpture")
    public Map<String,Object> butlerAppHeadSculpture(MultipartFile file){
        return butlerAppUploadService.butlerAppHeadSculpture(file);
    }

    /**
     * 上传咨询建议照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAdvice")
    public Map<String,Object> uploadAdvice(MultipartFile file){
        return uploadService.uploadAdvice(file);
    }

    /**
     * 上传物品信息照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadArticle")
    public Map<String,Object> uploadArticle(MultipartFile file){
        return uploadService.uploadArticle(file);
    }

    /**
     * 上传物品信息详情照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadArticleDetail")
    public Map<String,Object> uploadArticleDetail(MultipartFile file){
        return uploadService.uploadArticleDetail(file);
    }

    /**
     * 上传巡更人员自拍人脸
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadInspectionFace")
    public Map<String,Object> uploadInspectionFace(MultipartFile file){
        return uploadService.uploadInspectionFace(file);
    }

    /**
     * 上传巡更人员拍摄现场
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadInspectionSpace")
    public Map<String,Object> uploadInspectionSpace(MultipartFile file){
        return uploadService.uploadInspectionSpace(file);
    }

    /**
     * 上传设施/设备检查照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadFacilitiesCheckPhoto")
    public Map<String,Object> uploadFacilitiesCheckPhoto(MultipartFile file){
        return uploadService.uploadFacilitiesCheckPhoto(file);
    }

    /**
     * 上传处理完成照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadHousekeepingServiceHandlerPhone")
    public Map<String,Object> uploadHousekeepingServiceHandlerPhone(MultipartFile file){
        return uploadService.uploadHousekeepingServiceHandlerPhone(file);
    }

    /**
     * 上传报事报修工程维修照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadButlerAppEngineeringRepair")
    public Map<String,Object> uploadButlerAppEngineeringRepair(MultipartFile file){
        return uploadService.uploadButlerAppEngineeringRepair(file);
    }
}
