package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerAnnouncementDao;
import com.api.butlerApp.service.butler.ButlerAnnouncementService;
import com.api.model.app.TypeAndAnnouncementId;
import com.api.model.app.TypeAndNowDate;
import com.api.util.UploadUtil;
import com.api.vo.app.AppAnnouncementDetailVo;
import com.api.vo.app.AppAnnouncementVo;
import com.api.vo.butlerApp.ButlerAnnouncementDetailVo;
import com.api.vo.butlerApp.ButlerAnnouncementVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerAnnouncementServiceImpl implements ButlerAnnouncementService {
    @Resource
    ButlerAnnouncementDao butlerAnnouncementDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerAnnouncementVo> list() {
        TypeAndNowDate typeAndNowDate = new TypeAndNowDate();
        typeAndNowDate.setType(4);
        typeAndNowDate.setNowDate(new Date());
        List<ButlerAnnouncementVo> list = butlerAnnouncementDao.list(typeAndNowDate);
        if (list != null && list.size()>0){
            for (ButlerAnnouncementVo butlerAnnouncementVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", butlerAnnouncementVo.getId(), "announcementImg");
                butlerAnnouncementVo.setImgUrls(imgByDate);
            }
        }

        return list;
    }

    @Override
    public Map<String, Object> findById(Integer announcementId) {
        map = new HashMap<>();
        TypeAndAnnouncementId typeAndAnnouncementId = new TypeAndAnnouncementId();
        //4.管家
        typeAndAnnouncementId.setType(4);
        typeAndAnnouncementId.setAnnouncementId(announcementId);
        ButlerAnnouncementDetailVo butlerAnnouncementDetailVo = butlerAnnouncementDao.findById(typeAndAnnouncementId);
        if (butlerAnnouncementDetailVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysAnnouncementManagement", butlerAnnouncementDetailVo.getId(), "announcementImg");
            butlerAnnouncementDetailVo.setImgUrls(imgByDate);
        }
        map.put("message","请求成功");
        map.put("data",butlerAnnouncementDetailVo);
        map.put("status",true);
        return map;
    }
}
