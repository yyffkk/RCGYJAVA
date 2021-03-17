package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysInspectionPointDao;
import com.api.manage.service.butlerService.SysInspectionPointService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionCheckItems;
import com.api.model.butlerService.SysInspectionPoint;
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
}
