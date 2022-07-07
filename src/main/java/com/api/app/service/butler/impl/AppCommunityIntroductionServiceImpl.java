package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppCommunityIntroductionDao;
import com.api.app.service.butler.AppCommunityIntroductionService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppCommunityIntroductionVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppCommunityIntroductionServiceImpl implements AppCommunityIntroductionService {
    private static Map<String,Object> map = null;
    @Resource
    AppCommunityIntroductionDao appCommunityIntroductionDao;

    @Override
    public Map<String, Object> findEnable() {
        map = new HashMap<>();
        AppCommunityIntroductionVo appCommunityIntroductionVo = appCommunityIntroductionDao.findEnable();
        if (appCommunityIntroductionVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysCommunityIntroduction", appCommunityIntroductionVo.getId(), "communityIntroductionImg");
            appCommunityIntroductionVo.setImgList(imgByDate);
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appCommunityIntroductionVo);
        return map;
    }
}
