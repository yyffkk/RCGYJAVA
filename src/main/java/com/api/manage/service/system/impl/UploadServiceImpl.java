package com.api.manage.service.system.impl;

import com.api.manage.dao.butlerService.UserDecorationDao;
import com.api.manage.service.system.UploadService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.UserDecorationDoc;
import com.api.util.UploadUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-advice}")
    private String UPLOAD_ADVICE;
    @Value("${prop.upload-article}")
    private String UPLOAD_ARTICLE;
    @Value("${prop.upload-article-detail}")
    private String UPLOAD_ARTICLE_DETAIL;
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
    @Value("${prop.upload-decoration-notice-doc}")
    private String UPLOAD_DECORATION_NOTICE_DOC;
    @Value("${prop.upload-sponsor}")
    private String UPLOAD_SPONSOR;
    @Value("${prop.upload-repair}")
    private String UPLOAD_REPAIR;
    @Value("${prop.upload-owners-committee}")
    private String UPLOAD_OWNERS_COMMITTEE;
    @Value("${prop.upload-gambit-theme}")
    private String UPLOAD_GAMBIT_THEME;

    @Resource
    UserDecorationDao userDecorationDao;

    @Override
    public Map<String, Object> uploadAdvice(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ADVICE);
        return map;
    }

    @Override
    public Map<String, Object> uploadArticle(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ARTICLE);
        return map;
    }

    @Override
    public Map<String, Object> uploadArticleDetail(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ARTICLE_DETAIL);
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
    public Map<String, Object> uploadRepair(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_REPAIR);
        return map;
    }

    @Override
    public Map<String, Object> uploadOwnersCommittee(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_OWNERS_COMMITTEE);
        return map;
    }

    @Override
    public Map<String, Object> uploadGambitTheme(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_GAMBIT_THEME);
        return map;
    }

    @Override
    public Map<String, Object> uploadDecorationNoticeDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file,UPLOAD_DECORATION_NOTICE_DOC);
            //先删除全部装修须知doc文件
            userDecorationDao.deleteAllDoc();
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //再添加装修须知doc文件
            UserDecorationDoc userDecorationDoc = new UserDecorationDoc();
            userDecorationDoc.setName("装修须知");
            userDecorationDoc.setUrl(url);
            userDecorationDoc.setCreateId(sysUser.getId());
            userDecorationDoc.setCreateDate(new Date());
            int insert = userDecorationDao.insertDoc(userDecorationDoc);
            if (insert <= 0){
                throw new RuntimeException("添加数据库失败");
            }
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
