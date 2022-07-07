package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysNotificationManagementDao;
import com.api.model.operationManagement.NotificationManagement;
import com.api.model.operationManagement.SearchNotificationManagement;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.operationManagement.SysNotificationManagementService;
import com.api.vo.operationManagement.VoFindByIdNotificationManagement;
import com.api.vo.operationManagement.VoNotificationManagement;
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
public class SysNotificationManagementServiceImpl implements SysNotificationManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysNotificationManagementDao sysNotificationManagementDao;

    @Override
    public List<VoNotificationManagement> list(SearchNotificationManagement searchNotificationManagement) {
        return sysNotificationManagementDao.list(searchNotificationManagement);
    }

    @Override
    public Map<String, Object> insert(NotificationManagement notificationManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人id
        notificationManagement.setCreateId(sysUser.getId());
        //填入创建时间
        notificationManagement.setCreateDate(new Date());
        if (notificationManagement.getPushStatus() == 1){
            //填入推送时间
            notificationManagement.setPushDate(new Date());
        }
        //填入app阅读量，初始为0
        notificationManagement.setReadingVolume(0);
        //添加通知管理信息
        int insert = sysNotificationManagementDao.insert(notificationManagement);
        if (insert >0){
            map.put("message","添加通知管理信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加通知管理信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoFindByIdNotificationManagement findById(Integer id) {
        return sysNotificationManagementDao.findById(id);
    }

    @Override
    @Transactional
    public Map<String, Object> update(NotificationManagement notificationManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入修改人
            notificationManagement.setModifyId(sysUser.getId());
            //填入修改时间
            notificationManagement.setModifyDate(new Date());
            //如果修改的定时时间小于当前时间，则提示 定时时间不可小于当前时间
            if (notificationManagement.getTimingPush().getTime()<= new Date().getTime()){
                throw new RuntimeException("定时时间不可小于当前时间");
            }
            //根据主键id查询通知信息
            VoFindByIdNotificationManagement byId = sysNotificationManagementDao.findById(notificationManagement.getId());
            //如果定时时间为null,则不是定时通知，是实时通知（已推送）
            if (byId.getTimingPush() == null){
                throw new RuntimeException("此通知不是定时通知");
            }
            //如果定时时间小于或等于当前时间，提示通知已推送
            if (byId.getTimingPush().getTime() <= new Date().getTime()){
                throw new RuntimeException("通知已推送，无法修改");
            }
            //修改通知信息
            int update = sysNotificationManagementDao.update(notificationManagement);
            if (update <= 0){
                throw new RuntimeException("修改通知信息失败");
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
        map.put("message","修改通知信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据主键id删除通知信息
                int delete = sysNotificationManagementDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("通知信息删除成功");
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
        map.put("message","通知信息删除成功");
        map.put("status",true);
        return map;
    }
}
