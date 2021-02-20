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

}
