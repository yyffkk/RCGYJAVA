package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysOperationsDao;
import com.api.manage.service.butlerService.SysOperationsService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchOperations;
import com.api.model.butlerService.SysOperations;
import com.api.util.IdWorker;
import com.api.vo.butlerService.VoOperations;
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
public class SysOperationsServiceImpl implements SysOperationsService {
    private static Map<String,Object> map = null;
    @Resource
    SysOperationsDao sysOperationsDao;

    @Override
    public List<VoOperations> list(SearchOperations searchOperations) {
        return sysOperationsDao.list(searchOperations);
    }

    @Override
    public Map<String, Object> insert(SysOperations sysOperations) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysOperations.setCreateId(sysUser.getId());//填入创建人id
        sysOperations.setCreateDate(new Date());//填入创建时间
        sysOperations.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));//填入记录编号

        int insert = sysOperationsDao.insert(sysOperations);
        if (insert > 0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }

    @Override
    public Map<String, Object> update(SysOperations sysOperations) {
        map = new HashMap<>();

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        sysOperations.setModifyId(sysUser.getId());
        sysOperations.setModifyDate(new Date());

        int update = sysOperationsDao.update(sysOperations);
        if (update > 0){
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
                int delete = sysOperationsDao.delete(id);
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
