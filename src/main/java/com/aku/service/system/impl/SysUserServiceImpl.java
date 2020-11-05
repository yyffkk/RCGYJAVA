package com.aku.service.system.impl;

import com.aku.dao.system.SysUserDao;
import com.aku.model.system.SysUser;
import com.aku.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public Map registerSysUser(SysUser sysUser) {
        Map map = new HashMap();
        int integer = sysUserDao.registerSysUser(sysUser);
        if (integer >0){
            map.put("message","注册成功");
        }else {
            map.put("message","注册失败");
        }
        return map;
    }
}
