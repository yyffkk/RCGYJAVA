package com.api.systemDataBigScreen.service.impl;

import com.api.model.systemDataBigScreen.LilinAccessControlRecordTemplate;
import com.api.systemDataBigScreen.dao.LilinDataPushDao;
import com.api.systemDataBigScreen.service.LilinDataPushService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LilinDataPushServiceImpl implements LilinDataPushService {
    @Resource
    LilinDataPushDao lilinDataPushDao;
    private static Map<String,Object> map = null;

    @Override
    public String findClientSecretByClientId(String clientId) {
        return lilinDataPushDao.findClientSecretByClientId(clientId);
    }

    @Override
    public Map<String, Object> pushAccessControlRecord(LilinAccessControlRecordTemplate accessControlRecordTemplate) {
        map = new HashMap<>();

        int insert = lilinDataPushDao.pushAccessControlRecord(accessControlRecordTemplate.getData().getParam());
        if (insert >0){
            map.put("result",1);
            map.put("message","成功");
            map.put("data","门禁记录上报成功");
            map.put("requestId", UUID.randomUUID());
        }else {
            map.put("result",0);
            map.put("message","请求失败");
            map.put("data","门禁记录上报失败");
            map.put("requestId", UUID.randomUUID());
        }
        return map;
    }
}
