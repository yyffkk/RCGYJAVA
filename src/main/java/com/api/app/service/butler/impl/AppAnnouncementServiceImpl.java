package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppAnnouncementDao;
import com.api.app.service.butler.AppAnnouncementService;
import com.api.model.app.TypeAndAnnouncementId;
import com.api.model.app.TypeAndNowDate;
import com.api.util.UploadUtil;
import com.api.vo.app.AppAnnouncementDetailVo;
import com.api.vo.app.AppAnnouncementVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppAnnouncementServiceImpl implements AppAnnouncementService {
    @Resource
    AppAnnouncementDao appAnnouncementDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppAnnouncementVo> list(int type) {
        if (type == 2){
            //因为业主表 2.亲属 社区管理表 3.全部
            type = 3;
        }else if (type == 3){
            //因为业主表 3.租户 社区管理表 2.租户
            type = 2;
        }else if (type == 1){
            //因为业主表 1.业主 社区管理表 1.业主
            type = 1;
        }else {
            //没登录 查 3.全部
            type = 3;
        }
        TypeAndNowDate typeAndNowDate = new TypeAndNowDate();
        typeAndNowDate.setType(type);
        typeAndNowDate.setNowDate(new Date());
        List<AppAnnouncementVo> list = appAnnouncementDao.list(typeAndNowDate);
        if (list != null && list.size()>0){
            for (AppAnnouncementVo appAnnouncementVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", appAnnouncementVo.getId(), "announcementImg");
                appAnnouncementVo.setImgUrls(imgByDate);
            }
        }

        return list;
    }

    @Override
    public Map<String, Object> findById(Integer announcementId, Integer type) {
        map = new HashMap<>();
        if (type == 2){
            //因为业主表 2.亲属 社区管理表 3.全部
            type = 3;
        }else if (type == 3){
            //因为业主表 3.租户 社区管理表 2.租户
            type = 2;
        }else {
            //没登录 查 3.全部
            type = 3;
        }
        TypeAndAnnouncementId typeAndAnnouncementId = new TypeAndAnnouncementId();
        typeAndAnnouncementId.setType(type);
        typeAndAnnouncementId.setAnnouncementId(announcementId);
        AppAnnouncementDetailVo appAnnouncementVo = appAnnouncementDao.findById(typeAndAnnouncementId);
        if (appAnnouncementVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", appAnnouncementVo.getId(), "announcementImg");
            appAnnouncementVo.setImgUrls(imgByDate);
        }
        map.put("message","请求成功");
        map.put("data",appAnnouncementVo);
        map.put("status",true);
        return map;
    }
}
