package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysRegulationManagementDao;
import com.api.manage.service.operationManagement.SysRegulationManagementService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchRegulationManagement;
import com.api.model.operationManagement.SysRegulationManagement;
import com.api.vo.operationManagement.VoFBIRegulationManagement;
import com.api.vo.operationManagement.VoRegulationManagement;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRegulationManagementServiceImpl implements SysRegulationManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysRegulationManagementDao sysRegulationManagementDao;

    @Override
    public List<VoRegulationManagement> list(SearchRegulationManagement searchRegulationManagement) {
        return sysRegulationManagementDao.list(searchRegulationManagement);
    }

    @Override
    public Map<String, Object> insert(SysRegulationManagement sysRegulationManagement) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysRegulationManagement.setCreateId(sysUser.getId());
        sysRegulationManagement.setCreateDate(new Date());
        if (sysRegulationManagement.getStatus() == 1){ //1.已发布
            sysRegulationManagement.setReleaseDate(new Date()); //发布时间
        }

        int insert = sysRegulationManagementDao.insert(sysRegulationManagement);
        if (insert >0) {
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoFBIRegulationManagement voFBIRegulationManagement = sysRegulationManagementDao.findById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBIRegulationManagement);
        return map;
    }

    @Override
    public Map<String, Object> update(SysRegulationManagement sysRegulationManagement) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysRegulationManagement.setModifyId(sysUser.getId());
        sysRegulationManagement.setModifyDate(new Date());
        if (sysRegulationManagement.getStatus() == 1){ //1.已发布
            sysRegulationManagement.setReleaseDate(new Date()); //发布时间
        }

        int update = sysRegulationManagementDao.update(sysRegulationManagement);
        if (update >0) {
            map.put("message","修改成功");
            map.put("status",true);
        }else {
            map.put("message","修改失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int delete = sysRegulationManagementDao.delete(id);
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
    public Map<String, Object> release(Integer id) {
        map = new HashMap<>();

        SysRegulationManagement sysRegulationManagement = new SysRegulationManagement();
        sysRegulationManagement.setId(id);
        sysRegulationManagement.setReleaseDate(new Date());
        sysRegulationManagement.setStatus(1);
        
        int update = sysRegulationManagementDao.release(sysRegulationManagement);
        if (update >0) {
            map.put("message","发布成功");
            map.put("status",true);
        }else {
            map.put("message","发布失败");
            map.put("status",false);
        }
        return map;
    }
}
