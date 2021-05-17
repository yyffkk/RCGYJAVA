package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysHygieneAreaDao;
import com.api.manage.service.operationManagement.SysHygieneAreaService;
import com.api.model.businessManagement.SysUser;
import com.api.model.operationManagement.SearchHygieneArea;
import com.api.model.operationManagement.SysHygieneArea;
import com.api.vo.operationManagement.VoFBIHygieneArea;
import com.api.vo.operationManagement.VoHygieneArea;
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
public class SysHygieneAreaServiceImpl implements SysHygieneAreaService {
    private static Map<String,Object> map = null;
    @Resource
    SysHygieneAreaDao sysHygieneAreaDao;

    @Override
    public List<VoHygieneArea> list(SearchHygieneArea searchHygieneArea) {
        return sysHygieneAreaDao.list(searchHygieneArea);
    }

    @Override
    public Map<String, Object> insert(SysHygieneArea sysHygieneArea) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysHygieneArea.setCreateId(sysUser.getId());
        sysHygieneArea.setCreateDate(new Date());

        int insert = sysHygieneAreaDao.insert(sysHygieneArea);
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
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoFBIHygieneArea voFBIHygieneArea = sysHygieneAreaDao.findById(id);
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",voFBIHygieneArea);
        return map;
    }

    @Override
    public Map<String, Object> update(SysHygieneArea sysHygieneArea) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysHygieneArea.setModifyId(sysUser.getId());
        sysHygieneArea.setModifyDate(new Date());

        int update = sysHygieneAreaDao.update(sysHygieneArea);
        if (update >0){
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
                int delete = sysHygieneAreaDao.delete(id);
                if (delete <=0){
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
