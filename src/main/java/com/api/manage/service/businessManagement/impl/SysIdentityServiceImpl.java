package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysIdentityDao;
import com.api.manage.service.businessManagement.SysIdentityService;
import com.api.model.system.SysIdentity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysIdentityServiceImpl implements SysIdentityService {
    private static Map<String,Object> map = null;
    @Resource
    SysIdentityDao sysIdentityDao;

    @Override
    public Map<String, Object> listAll() {
        map = new HashMap<>();

        List<SysIdentity> sysIdentityList = sysIdentityDao.listAll();

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",sysIdentityList);

        return map;
    }
}
