package com.api.butlerApp.service.login.impl;

import com.api.butlerApp.dao.ButlerAppSignOutDao;
import com.api.butlerApp.dao.ButlerLoginDao;
import com.api.butlerApp.service.login.ButlerAppSignOutService;
import com.api.model.butlerApp.ButlerLoginToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ButlerAppSignOutServiceImpl implements ButlerAppSignOutService {
    @Resource
    ButlerAppSignOutDao butlerAppSignOutDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> signOut(Integer id) {
        map = new HashMap<>();
        int delete = butlerAppSignOutDao.signOut(id);
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
