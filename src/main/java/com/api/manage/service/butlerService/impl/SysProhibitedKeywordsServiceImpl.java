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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();

        try {
            for (int id : ids) {
                //根据违禁关键字信息主键id删除违禁关键字信息
                int delete = sysProhibitedKeywordsDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除失败");
                }

            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }


        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}
