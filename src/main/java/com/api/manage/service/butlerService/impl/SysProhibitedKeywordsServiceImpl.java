package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysProhibitedKeywordsDao;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.manage.service.butlerService.SysProhibitedKeywordsService;
import com.api.model.butlerService.SysProhibitedKeywords;
import com.api.vo.butlerService.VoProhibitedKeywords;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysProhibitedKeywordsServiceImpl implements SysProhibitedKeywordsService {
    private static Map<String,Object> map = null;
    @Resource
    SysProhibitedKeywordsDao sysProhibitedKeywordsDao;

    @Override
    public List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords) {
        return sysProhibitedKeywordsDao.list(searchProhibitedKeywords);
    }

    @Override
    public Map<String, Object> insert(SysProhibitedKeywords sysProhibitedKeywords) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysProhibitedKeywords.setCreateId(sysUser.getId());
        sysProhibitedKeywords.setCreateDate(new Date());

        int insert = sysProhibitedKeywordsDao.insert(sysProhibitedKeywords);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> update(SysProhibitedKeywords sysProhibitedKeywords) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysProhibitedKeywords.setModifyId(sysUser.getId());
        sysProhibitedKeywords.setModifyDate(new Date());

        int insert = sysProhibitedKeywordsDao.update(sysProhibitedKeywords);
        if (insert >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }

        return map;
    }
}
