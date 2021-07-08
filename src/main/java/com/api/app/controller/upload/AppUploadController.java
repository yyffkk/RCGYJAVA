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
    @PostMapping("/uploadAdvice")
    public Map<String,Object> uploadAdvice(MultipartFile file){
        return uploadService.uploadAdvice(file);
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

    /**
     * 上传营业执照照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadBusinessLicense")
    public Map<String,Object> uploadBusinessLicense(MultipartFile file){
        return uploadService.uploadBusinessLicense(file);
    }

    /**
     * 上传资质证书照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadQualificationCertificate")
    public Map<String,Object> uploadQualificationCertificate(MultipartFile file){
        return uploadService.uploadQualificationCertificate(file);
    }

    /**
     * 上传装修图纸照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadDecorationDrawings")
    public Map<String,Object> uploadDecorationDrawings(MultipartFile file){
        return uploadService.uploadDecorationDrawings(file);
    }

    /**
     * 上传装修申请表照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadDecorationApplicationForm")
    public Map<String,Object> uploadDecorationApplicationForm(MultipartFile file){
        return uploadService.uploadDecorationApplicationForm(file);
    }

    /**
     * 上传装修承诺书照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadDecorationCommitment")
    public Map<String,Object> uploadDecorationCommitment(MultipartFile file){
        return uploadService.uploadDecorationCommitment(file);
    }

    /**
     * 上传身份证正面照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAppIdCardFront")
    public Map<String,Object> uploadAppIdCardFront(MultipartFile file){
        return uploadService.uploadAppIdCardFront(file);
    }

    /**
     * 上传身份证背面照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAppIdCardBack")
    public Map<String,Object> uploadAppIdCardBack(MultipartFile file){
        return uploadService.uploadAppIdCardBack(file);
    }

    /**
     * 上传租赁合同签名照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadLeaseContractSignaturePhoto")
    public Map<String,Object> uploadLeaseContractSignaturePhoto(MultipartFile file){
        return uploadService.uploadLeaseContractSignaturePhoto(file);
    }

    /**
     * 上传租赁有效（正式）合同pdf
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadLeaseContractValidPdf")
    public Map<String,Object> uploadLeaseContractValidPdf(MultipartFile file){
        return uploadService.uploadLeaseContractValidPdf(file);
    }

    /**
     * 上传腾空单
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAppClearingSingle")
    public Map<String,Object> uploadAppClearingSingle(MultipartFile file){
        return uploadService.uploadAppClearingSingle(file);
    }

    /**
     * 访客邀请上传身份证正面照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAppVisitIdCardFront")
    public Map<String,Object> uploadAppVisitIdCardFront(MultipartFile file){
        return uploadService.uploadAppVisitIdCardFront(file);
    }

    /**
     * 访客邀请上传身份证背面照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAppVisitIdCardBack")
    public Map<String,Object> uploadAppVisitIdCardBack(MultipartFile file){
        return uploadService.uploadAppVisitIdCardBack(file);
    }

}
