package com.api.manage.controller.system;

import com.api.manage.service.system.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 上传文件
 */
@RestController
@RequestMapping("manage/upload")
public class UploadController {
    @Resource
    UploadService uploadService;


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
     * 上传话题照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadGambit")
    public Map<String,Object> uploadGambit(MultipartFile file){
        return uploadService.uploadGambit(file);
    }

    /**
     * 上传投票标题照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadVoteTitle")
    public Map<String,Object> uploadVoteTitle(MultipartFile file){
        return uploadService.uploadVoteTitle(file);
    }

    /**
     * 上传投票候选人照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadVoteCandidate")
    public Map<String,Object> uploadVoteCandidate(MultipartFile file){
        return uploadService.uploadVoteCandidate(file);
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
     * 上传公告信息照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAnnouncement")
    public Map<String,Object> uploadAnnouncement(MultipartFile file){
        return uploadService.uploadAnnouncement(file);
    }

    /**
     * 上传公告信息doc,docx文件
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadAnnouncementDoc")
    public Map<String,Object> uploadAnnouncementDoc(MultipartFile file){
        return uploadService.uploadAnnouncementDoc(file);
    }

    /**
     * 上传主办方信息 营业执照照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadSponsor")
    public Map<String,Object> uploadSponsor(MultipartFile file){
        return uploadService.uploadSponsor(file);
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
     * 上传装修须知doc,docx文件
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadDecorationNoticeDoc")
    public Map<String,Object> uploadDecorationNoticeDoc(MultipartFile file){
        return uploadService.uploadDecorationNoticeDoc(file);
    }

    /**
     * 上传审核信息相关照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadEstateExamine")
    public Map<String,Object> uploadEstateExamine(MultipartFile file){
        return uploadService.uploadEstateExamine(file);
    }

    /**
     * 上传问卷调查封面照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadQuestionnaireCoverPhoto")
    public Map<String,Object> uploadQuestionnaireCoverPhoto(MultipartFile file){
        return uploadService.uploadQuestionnaireCoverPhoto(file);
    }

    /**
     * 上传设施分类照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadFacilitiesCategory")
    public Map<String,Object> uploadFacilitiesCategory(MultipartFile file){
        return uploadService.uploadFacilitiesCategory(file);
    }

    /**
     * 上传商品照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadShoppingGoods")
    public Map<String,Object> uploadShoppingGoods(MultipartFile file){
        return uploadService.uploadShoppingGoods(file);
    }

    /**
     * 上传分类照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadShoppingCategory")
    public Map<String,Object> uploadShoppingCategory(MultipartFile file){
        return uploadService.uploadShoppingCategory(file);
    }

    /**
     * 上传供应商照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadShoppingSupplier")
    public Map<String,Object> uploadShoppingSupplier(MultipartFile file){
        return uploadService.uploadShoppingSupplier(file);
    }


    /**
     * 上传资讯照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadNews")
    public Map<String,Object> uploadNews(MultipartFile file){
        return uploadService.uploadNews(file);
    }

    /**
     * 上传电子商务照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadElectronicCommerce")
    public Map<String,Object> uploadElectronicCommerce(MultipartFile file){
        return uploadService.uploadElectronicCommerce(file);
    }

    /**
     * 上传社区介绍照片
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadCommunityIntroduction")
    public Map<String,Object> uploadCommunityIntroduction(MultipartFile file){
        return uploadService.uploadCommunityIntroduction(file);
    }

    /**
     * 上传合同信息doc,docx文件
     * @param file 上传文件
     * @return map
     */
    @PostMapping("/uploadContractDoc")
    public Map<String,Object> uploadContractDoc(MultipartFile file){
        return uploadService.uploadContractDoc(file);
    }
}
