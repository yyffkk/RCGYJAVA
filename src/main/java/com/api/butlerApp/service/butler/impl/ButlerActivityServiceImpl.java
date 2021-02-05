package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerActivityDao;
import com.api.butlerApp.service.butler.ButlerActivityService;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerActivityFBIdVo;
import com.api.vo.butlerApp.ButlerActivityVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerActivityServiceImpl implements ButlerActivityService {
    @Resource
    ButlerActivityDao butlerActivityDao;
    private static Map<String,Object> map = null;

    @Override
    public List<ButlerActivityVo> list() {
        List<ButlerActivityVo> list = butlerActivityDao.list();
        if (list != null && list.size()>0){
            for (ButlerActivityVo butlerActivityVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", butlerActivityVo.getId(), "activityImg");
                butlerActivityVo.setImgUrls(imgByDate);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> findById(Integer activityId) {
        map = new HashMap<>();
        ButlerActivityFBIdVo activityFBIdVo = butlerActivityDao.findById(activityId);
        if (activityFBIdVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysActivityManagement", activityFBIdVo.getId(), "activityImg");
            activityFBIdVo.setImgUrls(imgByDate);
        }
        map.put("data",activityFBIdVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }
}
