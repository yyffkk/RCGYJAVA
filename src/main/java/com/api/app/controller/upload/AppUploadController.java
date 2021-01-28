package com.api.app.controller.upload;

import com.api.app.service.upload.AppUploadService;
import com.api.manage.service.system.UploadService;
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
@RequestMapping("app/user/upload")
public class AppUploadController {
    @Resource
    AppUploadService appUploadService;
    @Resource
    UploadService uploadService;

    /**
     * 上传个人资料头像照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/appHeadSculpture")
    public Map<String,Object> appHeadSculpture(MultipartFile file){
        return appUploadService.appHeadSculpture(file);
    }

    /**
     * 上传咨询建议照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadArticle")
    public Map<String,Object> uploadArticle(MultipartFile file){
        return uploadService.uploadArticle(file);
    }

    /**
     * 上传话题照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadGambit")
    public Map<String,Object> uploadGambit(MultipartFile file){
        return uploadService.uploadGambit(file);
    }


    /**
     * 上传固定金额分摊缴纳凭证照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadVoucher")
    public Map<String,Object> uploadVoucher(MultipartFile file){
        return uploadService.uploadVoucher(file);
    }

    /**
     * 上传活动信息照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadActivity")
    public Map<String,Object> uploadActivity(MultipartFile file){
        return uploadService.uploadActivity(file);
    }


    /**
     * 上传报事报修信息 报事报修照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadRepair")
    public Map<String,Object> uploadRepair(MultipartFile file){
        return uploadService.uploadRepair(file);
    }

    /**
     * 上传业委会照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadOwnersCommittee")
    public Map<String,Object> uploadOwnersCommittee(MultipartFile file){
        return uploadService.uploadOwnersCommittee(file);
    }

    /**
     * 上传主题照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadGambitTheme")
    public Map<String,Object> uploadGambitTheme(MultipartFile file){
        return uploadService.uploadGambitTheme(file);
    }

}
