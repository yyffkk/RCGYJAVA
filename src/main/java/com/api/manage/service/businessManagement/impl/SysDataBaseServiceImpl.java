package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysDataBaseDao;
import com.api.manage.service.businessManagement.SysDataBaseService;
import com.api.model.businessManagement.SearchDataBase;
import com.api.model.businessManagement.SysDataBase;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoDataBase;
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
public class SysDataBaseServiceImpl implements SysDataBaseService {
    private static Map<String,Object> map = null;
    @Resource
    SysDataBaseDao sysDataBaseDao;

    @Override
    public List<VoDataBase> list(SearchDataBase searchDataBase) {
        return sysDataBaseDao.list(searchDataBase);
    }

    @Override
    public Map<String, Object> insert(SysDataBase sysDataBase) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysDataBase.setCreateId(sysUser.getId());
        sysDataBase.setCreateDate(new Date());

        int insert = sysDataBaseDao.insert(sysDataBase);
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
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();

        try {
            for (int id : ids) {
                int delete = sysDataBaseDao.delete(id);
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

    @Override
    public Map<String, Object> update(SysDataBase sysDataBase) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysDataBase.setModifyId(sysUser.getId());
        sysDataBase.setModifyDate(new Date());

        int update = sysDataBaseDao.update(sysDataBase);
        if (update >0){
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }
}
