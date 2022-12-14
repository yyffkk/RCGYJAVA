package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysConveniencePhoneDao;
import com.api.model.butlerService.SearchConveniencePhone;
import com.api.model.butlerService.SysConveniencePhone;
import com.api.model.butlerService.SysConveniencePhoneReminder;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysConveniencePhoneService;
import com.api.vo.butlerService.VoConveniencePhone;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysConveniencePhoneServiceImpl implements SysConveniencePhoneService {
    private static Map<String,Object> map = null;
    @Resource
    SysConveniencePhoneDao sysConveniencePhoneDao;

    @Override
    public List<VoConveniencePhone> list(SearchConveniencePhone searchConveniencePhone) {
        List<VoConveniencePhone> list = sysConveniencePhoneDao.list(searchConveniencePhone);
        if (list != null){
            for (VoConveniencePhone voConveniencePhone : list) {
                //如果下次检查时间大于当前时间，怎将检查状态显示为 0.未检查
                if (voConveniencePhone.getNextControlDate().getTime() <= (new Date()).getTime()){
                    voConveniencePhone.setCheckStatus(0);
                }
            }
        }

        return list;
    }

    @Override
    public Map<String, Object> insert(SysConveniencePhone sysConveniencePhone) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人id
        sysConveniencePhone.setCreateId(sysUser.getId());
        //填入创建时间
        sysConveniencePhone.setCreateDate(new Date());
        //填入检查状态
        sysConveniencePhone.setCheckStatus(1);

        //根据主键id查询提醒间隔和内容（不可能为null）
        SysConveniencePhoneReminder sysConveniencePhoneReminder = sysConveniencePhoneDao.findRemindById(1);
        //填入下次检查时间
        Calendar rightNow = Calendar.getInstance();
        Date date = new Date();
        rightNow.setTime(date);
        if (sysConveniencePhoneReminder.getReminderInterval() == 1){
            //间隔一个月
            rightNow.add(Calendar.MONTH, 1);
            date = rightNow.getTime();
        }else if (sysConveniencePhoneReminder.getReminderInterval() == 2){
            //间隔半年
            rightNow.add(Calendar.MONTH, 6);
            date = rightNow.getTime();
        }
        sysConveniencePhone.setNextControlDate(date);
        //填入提醒内容
        sysConveniencePhone.setRemindContent(sysConveniencePhoneReminder.getReminderContent());

        //添加便民电话信息
        int insert = sysConveniencePhoneDao.insert(sysConveniencePhone);
        if (insert >0){
            map.put("message","添加便民电话成功");
            map.put("status",true);
        }else {
            map.put("message","添加便民电话失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        VoConveniencePhone voConveniencePhone = sysConveniencePhoneDao.findById(id);
        if (voConveniencePhone != null){
            //如果下次检查时间大于当前时间，怎将检查状态显示为 0.未检查
            if (voConveniencePhone.getNextControlDate().getTime() <= (new Date()).getTime()){
                voConveniencePhone.setCheckStatus(0);
            }
        }
        map.put("voConveniencePhone",voConveniencePhone);
        return map;
    }

    @Override
    public Map<String, Object> update(SysConveniencePhone sysConveniencePhone) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人id
        sysConveniencePhone.setModifyId(sysUser.getId());
        //填入修改时间
        sysConveniencePhone.setModifyDate(new Date());
        //填入检查状态
        sysConveniencePhone.setCheckStatus(1);

        //根据主键id查询提醒间隔和内容（不可能为null）
        SysConveniencePhoneReminder sysConveniencePhoneReminder = sysConveniencePhoneDao.findRemindById(1);
        //填入下次检查时间
        Calendar rightNow = Calendar.getInstance();
        Date date = new Date();
        rightNow.setTime(date);
        if (sysConveniencePhoneReminder.getReminderInterval() == 1){
            //间隔一个月
            rightNow.add(Calendar.MONTH, 1);
            date = rightNow.getTime();
        }else if (sysConveniencePhoneReminder.getReminderInterval() == 2){
            //间隔半年
            rightNow.add(Calendar.MONTH, 6);
            date = rightNow.getTime();
        }
        sysConveniencePhone.setNextControlDate(date);
        //填入提醒内容
        sysConveniencePhone.setRemindContent(sysConveniencePhoneReminder.getReminderContent());

        //更新便民电话信息
        int update = sysConveniencePhoneDao.update(sysConveniencePhone);
        if (update > 0){
            map.put("message","更新便民电话信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新便民电话信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateReminder(SysConveniencePhoneReminder sysConveniencePhoneReminder) {
        map = new HashMap<>();
        //目前定时检查就一个，固定id为1
        sysConveniencePhoneReminder.setId(1);
        //更新定时检查信息
        int update = sysConveniencePhoneDao.updateReminder(sysConveniencePhoneReminder);
        if (update >0){
            map.put("message","更新定时检查信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新定时检查信息失败");
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
                int delete = sysConveniencePhoneDao.delete(id);
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
