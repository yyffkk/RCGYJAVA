package com.api.app.service.my.impl;

import com.api.app.dao.login.AppLoginDao;
import com.api.app.dao.my.MyHouseDao;
import com.api.app.service.my.MyHouseService;
import com.api.app.service.personalData.PersonalDataService;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyHouseServiceImpl implements MyHouseService {
    @Resource
    MyHouseDao myHouseDao;
    @Resource
    AppLoginDao appLoginDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> authentication(ResidentIdAndEstateId residentIdAndEstateId) {
        map =  new HashMap<>();
        int insert = appLoginDao.insertResidentEstateExamine(residentIdAndEstateId);
        if (insert >0){
            map.put("message","认证成功，等待审核");
            map.put("status",true);
        }else {
            map.put("message","认证失败");
            map.put("status",false);
        }

        return map;
    }
}
