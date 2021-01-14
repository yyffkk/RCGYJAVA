package com.api.app.service.my.impl;

import com.api.app.dao.my.AppSignOutDao;
import com.api.app.service.my.AppSignOutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppSignOutServiceImpl implements AppSignOutService {
    @Resource
    AppSignOutDao appSignOutDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> signOut(Integer id) {
        map = new HashMap<>();
        int delete = appSignOutDao.signOut(id);
        if (delete >0){
            map.put("message","退出成功");
            map.put("status",true);
        }else {
            map.put("message","退出失败");
            map.put("status",false);
        }
        return map;
    }
}
