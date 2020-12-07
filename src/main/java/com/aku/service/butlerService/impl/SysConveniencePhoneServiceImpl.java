package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.SysConveniencePhoneDao;
import com.aku.model.butlerService.SearchConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhone;
import com.aku.model.butlerService.SysConveniencePhoneReminder;
import com.aku.model.system.SysUser;
import com.aku.service.butlerService.SysConveniencePhoneService;
import com.aku.vo.butlerService.VoConveniencePhone;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

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
                //如果下次检查时间大于当前时间，怎将检查状态改为 0.未检查
                if (voConveniencePhone.getNextControlDate().getTime() <= (new Date()).getTime()){
                    SysConveniencePhone sysConveniencePhone = new SysConveniencePhone();
                    sysConveniencePhone.setId(voConveniencePhone.getId());
                    sysConveniencePhone.setCheckStatus(0);
                    sysConveniencePhoneDao.update(sysConveniencePhone);
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
}
