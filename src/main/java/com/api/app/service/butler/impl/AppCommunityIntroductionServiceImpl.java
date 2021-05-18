package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppCommunityIntroductionDao;
import com.api.app.service.butler.AppCommunityIntroductionService;
import com.api.vo.app.AppCommunityIntroductionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appCommunityIntroductionVo);
        return map;
    }
}
