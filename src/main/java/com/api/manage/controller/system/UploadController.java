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


}
