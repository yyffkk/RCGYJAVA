package com.api.manage.service.system.impl;

import com.api.manage.service.system.UploadService;
import com.api.util.UploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-article}")
    private String UPLOAD_ARTICLE;
    @Value("${prop.upload-gambit}")
    private String UPLOAD_GAMBIT;
    @Value("${prop.upload-vote-title}")
    private String UPLOAD_VOTE_TITLE;
    @Value("${prop.upload-vote-candidate}")
    private String UPLOAD_VOTE_CANDIDATE;
    @Value("${prop.upload-voucher}")
    private String UPLOAD_VOUCHER;
    @Value("${prop.upload-activity}")
    private String UPLOAD_ACTIVITY;
    @Value("${prop.upload-announcement}")
    private String UPLOAD_ANNOUNCEMENT;
    @Value("${prop.upload-announcement-doc}")
    private String UPLOAD_ANNOUNCEMENT_DOC;
    @Value("${prop.upload-sponsor}")
    private String UPLOAD_SPONSOR;

    @Override
    public Map<String, Object> uploadArticle(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ARTICLE);
        return map;
    }

    @Override
    public Map<String, Object> uploadGambit(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_GAMBIT);
        return map;
    }

    @Override
    public Map<String, Object> uploadVoteTitle(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_VOTE_TITLE);
        return map;
    }

    @Override
    public Map<String, Object> uploadVoteCandidate(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_VOTE_CANDIDATE);
        return map;
    }

    @Override
    public Map<String, Object> uploadVoucher(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_VOUCHER);
        return map;
    }

    @Override
    public Map<String, Object> uploadActivity(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ACTIVITY);
        return map;
    }

    @Override
    public Map<String, Object> uploadAnnouncement(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ANNOUNCEMENT);
        return map;
    }

    @Override
    public Map<String, Object> uploadSponsor(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SPONSOR);
        return map;
    }

    @Override
    public Map<String, Object> uploadAnnouncementDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file, UPLOAD_ANNOUNCEMENT_DOC);
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
