package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysInspectionPointDao;
import com.api.manage.service.butlerService.SysInspectionPointService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionCheckItems;
import com.api.model.butlerService.SysInspectionPoint;
import com.api.vo.butlerService.VoFBIInspectionCheckItems;
import com.api.vo.butlerService.VoFBIInspectionPoint;
import com.api.vo.butlerService.VoInspectionPoint;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysInspectionPointServiceImpl implements SysInspectionPointService {
    @Resource
    SysInspectionPointDao sysInspectionPointDao;
    private static Map<String,Object> map = null;

    @Override
    public List<VoInspectionPoint> list(SearchInspectionPoint searchInspectionPoint) {
        return sysInspectionPointDao.list(searchInspectionPoint);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysInspectionPoint sysInspectionPoint) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if (sysInspectionPoint.getCode() == null){
            sysInspectionPoint.setCode(UUID.randomUUID().toString().replace("-","").trim());
        }
        sysInspectionPoint.setCreateDate(new Date()); //填入创建时间
        sysInspectionPoint.setCreateId(sysUser.getId()); //填入创建人id
        sysInspectionPoint.setIsDelete(1); //默认1.非删
        try {
            //添加巡检点信息
            int insert = sysInspectionPointDao.insert(sysInspectionPoint);
            if (insert <= 0){
                throw new RuntimeException("添加巡检点失败");
            }
            if (sysInspectionPoint.getItemsList() != null && sysInspectionPoint.getItemsList().size()>0){
                for (SysInspectionCheckItems checkItems : sysInspectionPoint.getItemsList()) {
                    checkItems.setInspectionPointId(sysInspectionPoint.getId());
                    //添加巡检点检查项
                    int insert2 = sysInspectionPointDao.insertCheckItems(checkItems);
                    if (insert2 <=0){
                        throw new RuntimeException("添加巡检点检查项失败");
                    }
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoFBIInspectionPoint voPoint = sysInspectionPointDao.findById(id);
        if (voPoint != null){
            List<VoFBIInspectionCheckItems> voItemsList = sysInspectionPointDao.findByIdCheckItems(voPoint.getId());
            voPoint.setCheckItemsList(voItemsList);
        }
        map.put("data",voPoint);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysInspectionPoint sysInspectionPoint) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            sysInspectionPoint.setModifyId(sysUser.getId());
            sysInspectionPoint.setModifyDate(new Date());
            int update = sysInspectionPointDao.update(sysInspectionPoint);
            if (update <= 0){
                throw new RuntimeException("修改巡检点信息失败");
            }
            //先删除巡检点选择项
            sysInspectionPointDao.deleteCheckItems(sysInspectionPoint.getId());
            //再添加巡检点选择项
            if (sysInspectionPoint.getItemsList() != null && sysInspectionPoint.getItemsList().size()>0){
                for (SysInspectionCheckItems checkItems : sysInspectionPoint.getItemsList()) {
                    checkItems.setInspectionPointId(sysInspectionPoint.getId());
                    int insert = sysInspectionPointDao.insertCheckItems(checkItems);
                    if (insert <= 0){
                        throw new RuntimeException("修改巡检点检查项失败");
                    }
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
        map.put("message","修改成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int update = sysInspectionPointDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除巡检点失败");
                }
            }
        } catch (RuntimeException e) {
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
        map.put("message","删除巡检点成功");
        map.put("status",true);
        return map;
    }
}
