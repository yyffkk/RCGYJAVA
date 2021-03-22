package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysInspectionRouteDao;
import com.api.manage.service.butlerService.SysInspectionRouteService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.RouteIdAndStatus;
import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionPointRoute;
import com.api.model.butlerService.SysInspectionRoute;
import com.api.vo.butlerService.VoFBIInspectionRoute;
import com.api.vo.butlerService.VoFBIInspectionRoutePoint;
import com.api.vo.butlerService.VoInspectionRoute;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysInspectionRouteServiceImpl implements SysInspectionRouteService {
    @Resource
    SysInspectionRouteDao sysInspectionRouteDao;
    private static Map<String,Object> map = null;


    @Override
    public List<VoInspectionRoute> list(SearchInspectionPoint searchInspectionPoint) {
        return sysInspectionRouteDao.list(searchInspectionPoint);
    }

    @Override
    @Transactional
    public Map<String, Object> insert(SysInspectionRoute sysInspectionRoute) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            if (sysInspectionRoute.getCode() == null){
                sysInspectionRoute.setCode(UUID.randomUUID().toString().replace("-","").trim());
            }
            sysInspectionRoute.setCreateId(sysUser.getId()); //添加创建人
            sysInspectionRoute.setCreateDate(new Date()); //添加创建时间
            sysInspectionRoute.setStatus(1); //默认状态为1.启用
            //添加巡检路线
            int insert = sysInspectionRouteDao.insert(sysInspectionRoute);
            if (insert <= 0){
                throw new RuntimeException("添加巡检路线失败");
            }
            if (sysInspectionRoute.getPointRouteList() != null && sysInspectionRoute.getPointRouteList().size()>0){
                for (SysInspectionPointRoute pointRoute : sysInspectionRoute.getPointRouteList()) {
                    pointRoute.setInspectionRouteId(sysInspectionRoute.getId());
                    //添加巡检路线-点关联
                    int insert2 = sysInspectionRouteDao.insertPointRoute(pointRoute);
                    if (insert2 <= 0){
                        throw new RuntimeException("添加巡检路线-点关联失败");
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
        map.put("message","添加巡检路线成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findById(Integer id) {
        map = new HashMap<>();
        //根据巡检路线主键id查询巡检路线信息
        VoFBIInspectionRoute voFBIInspectionRoute = sysInspectionRouteDao.findById(id);
        if (voFBIInspectionRoute != null){
            //根据巡检路线主键id查询包含的巡检点信息
            List<VoFBIInspectionRoutePoint> voFBIInspectionRoutePoint = sysInspectionRouteDao.findByIdRoutePoint(voFBIInspectionRoute.getId());
            voFBIInspectionRoute.setVoRoutePointList(voFBIInspectionRoutePoint);
        }
        map.put("data",voFBIInspectionRoute);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> update(SysInspectionRoute sysInspectionRoute) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            sysInspectionRoute.setCreateId(sysUser.getId());
            sysInspectionRoute.setCreateDate(new Date());
            //修改巡检路线信息
            int update = sysInspectionRouteDao.update(sysInspectionRoute);
            if (update <= 0){
                throw new RuntimeException("修改巡检路线信息失败");
            }

            //先删除巡检路线包含的巡检点信息
            sysInspectionRouteDao.deleteRoutePoint(sysInspectionRoute.getId());
            if (sysInspectionRoute.getPointRouteList() != null && sysInspectionRoute.getPointRouteList().size()>0){
                for (SysInspectionPointRoute pointRoute : sysInspectionRoute.getPointRouteList()) {
                    pointRoute.setInspectionRouteId(sysInspectionRoute.getId());
                    //再添加巡检路线包含的巡检点信息
                    int insert = sysInspectionRouteDao.insertPointRoute(pointRoute);
                    if (insert <= 0){
                        throw new RuntimeException("重新添加巡检点信息成功");
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
        map.put("message","修改巡检路线成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据巡检路线主键id查询巡检路线是否启用
                int status = sysInspectionRouteDao.findStatusById(id);
                if (status == 1){//1.启用，无法删除
                    throw new RuntimeException("请先禁用该路线，才可删除");
                }
                int update = sysInspectionRouteDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除巡检路线失败");
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
        map.put("message","删除巡检路线成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> isEnable(Integer id) {
        map = new HashMap<>();
        try {
            //根据巡检路线主键id查询启用状态
            int status = sysInspectionRouteDao.findStatusById(id);
            String msg = "";
            if (status == 1){
                //根据巡检路线主键id查询巡检计划是否启用
                Integer status2 = sysInspectionRouteDao.findPlanStatusById(id);
                if (status2 > 0){ //大于0，巡检计划启用,巡检路线无法删除
                    throw new RuntimeException("请先禁用巡检计划");
                }
                msg = "停用";
                status =2;
            }else{
                msg = "启用";
                status =1;
            }
            RouteIdAndStatus routeIdAndStatus = new RouteIdAndStatus();
            routeIdAndStatus.setId(id);
            routeIdAndStatus.setStatus(status);
            //修改启用状态
            int update = sysInspectionRouteDao.updateStatusById(routeIdAndStatus);
            if (update > 0){
                map.put("message",msg+"成功");
                map.put("status",true);
            }else {
                map.put("message",msg+"失败");
                map.put("status",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","数据有误");
            map.put("status",false);
            return map;
        }
        return map;
    }
}
