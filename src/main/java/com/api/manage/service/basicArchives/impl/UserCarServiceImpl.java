package com.api.manage.service.basicArchives.impl;

import com.api.manage.dao.basicArchives.CpmBuildingDao;
import com.api.manage.dao.basicArchives.CpmBuildingUnitDao;
import com.api.manage.dao.basicArchives.UserCarDao;
import com.api.model.basicArchives.CpmBuilding;
import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.basicArchives.SearchUserCar;
import com.api.model.basicArchives.UserCar;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.basicArchives.UserCarService;
import com.api.vo.basicArchives.VoUserCar;
import com.api.vo.basicArchives.VoUserCarFindById;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserCarServiceImpl implements UserCarService {
    private final Map<String,Object> map = new HashMap<>();
    @Resource
    UserCarDao userCarDao;
    @Resource
    CpmBuildingUnitDao cpmBuildingUnitDao;
    @Resource
    CpmBuildingDao cpmBuildingDao;

    @Override
    public List<VoUserCar> list(SearchUserCar searchUserCar) {
        List<VoUserCar> userCarList = userCarDao.list(searchUserCar);
        //遍历查询出房产对应的单元和楼栋
        for (VoUserCar voUserCar : userCarList) {
            if (voUserCar.getStatus() == 2|| voUserCar.getStatus() == 3){
                //为包月包年，计算剩余时间
                long l = voUserCar.getEffectiveTimeEnd().getTime() - (new Date()).getTime();
                //判断是否还有剩余时间
                if (l>0){
                    //填入剩余时间
                    voUserCar.setRemainingTime(l);
                }else {
                    //填入剩余时间
                    voUserCar.setRemainingTime(0L);
                }
            }else {
                //其他置为null
                voUserCar.setRemainingTime(null);
            }
        }
        return userCarList;
    }

    @Override
    public Map<String, Object> insert(UserCar userCar) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        if (userCar.getStatus() == 2){
            Date date = new Date();
            //设置有效开始时间
            userCar.setEffectiveTimeStart(date);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, 1); //把日期往后增加一年，负数减一年
            date = calendar.getTime();
            //设置有效结束时间
            userCar.setEffectiveTimeEnd(date);
        }else if (userCar.getStatus() == 3){
            Date date = new Date();
            //设置有效开始时间
            userCar.setEffectiveTimeStart(date);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1); //把日期往后增加一年，负数减一年
            date = calendar.getTime();
            //设置有效结束时间
            userCar.setEffectiveTimeEnd(date);
        }else {
            //全部置为null
            //设置有效开始时间
            userCar.setEffectiveTimeStart(null);
            //设置有效结束时间
            userCar.setEffectiveTimeEnd(null);
        }
        //填入创建人
        userCar.setCreateId(sysUser.getId());
        //填入创建时间
        userCar.setCreateDate(new Date());

        //添加车辆信息
        int insert = userCarDao.insert(userCar);
        if (insert >0){
            map.put("message","添加车辆信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加车辆信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoUserCarFindById findById(Integer id) {
        VoUserCarFindById voUserCarFindById = userCarDao.findById(id);
        //根据房产主键id查询对应的单元号
        CpmBuildingUnit cpmBuildingUnit = cpmBuildingUnitDao.findById(voUserCarFindById.getBuildingUnitEstateId());
        //根据单元主键id查询对应的楼栋号
        CpmBuilding cpmBuilding = cpmBuildingDao.findById(cpmBuildingUnit.getBuildingId());
        //设置 楼栋id，单元id，房产id
        voUserCarFindById.setBuildingUnitId(cpmBuildingUnit.getId());
        voUserCarFindById.setBuildingId(cpmBuilding.getId());
        return voUserCarFindById;
    }

    @Override
    public Map<String, Object> update(UserCar userCar) {
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //设置修改人id和修改时间
        userCar.setModifyId(sysUser.getId());
        userCar.setModifyDate(new Date());
        //判断车辆状态，并处理有效时间
        if (userCar.getStatus() == 2){
            VoUserCarFindById byId = userCarDao.findById(userCar.getId());
            Calendar calendar = new GregorianCalendar();
            //如果原先没有包月，包年，设置当前时间为开始时间
            if (byId.getStatus() == 1 || byId.getStatus() == 4){
                byId.setEffectiveTimeStart(new Date());
            }

            calendar.setTime(byId.getEffectiveTimeStart());
            calendar.add(Calendar.YEAR, 1); //把日期往后增加一年，负数减一年
            Date date = calendar.getTime();
            //设置有效结束时间
            userCar.setEffectiveTimeEnd(date);
        }else if (userCar.getStatus() == 3){
            VoUserCarFindById byId = userCarDao.findById(userCar.getId());
            Calendar calendar = new GregorianCalendar();
            //如果原先没有包月，包年，设置当前时间为开始时间
            if (byId.getStatus() == 1 || byId.getStatus() == 4){
                byId.setEffectiveTimeStart(new Date());
            }

            calendar.setTime(byId.getEffectiveTimeStart());
            calendar.add(Calendar.MONTH, 1); //把日期往后增加一月，负数减一月
            Date date = calendar.getTime();
            //设置有效结束时间
            userCar.setEffectiveTimeEnd(date);
        }else {
            //全部置为null
            userCar.setEffectiveTimeStart(null);
            userCar.setEffectiveTimeEnd(null);
        }

        int update = userCarDao.update(userCar);
        if (update >0){
            map.put("message","修改车辆信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改车辆信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        try {
            for (int id : ids) {
                int delete = userCarDao.delete(id);
                if (delete<=0){
                    throw new RuntimeException("批量删除车辆信息失败");
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
        map.put("message","批量删除车辆信息成功");
        map.put("status",true);
        return map;
    }


}
