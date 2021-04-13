package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysWorkOrderTypeDao;
import com.api.manage.dao.butlerService.SysWorkOrderTypeDetailDao;
import com.api.model.butlerService.SysWorkOrderType;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysWorkOrderTypeService;
import com.api.vo.butlerService.VoWorkOrderType;
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
public class SysWorkOrderTypeServiceImpl implements SysWorkOrderTypeService {
    private static Map<String,Object> map = null;
    @Resource
    SysWorkOrderTypeDao sysWorkOrderTypeDao;
    @Resource
    SysWorkOrderTypeDetailDao sysWorkOrderTypeDetailDao;

    @Override
    public List<VoWorkOrderType> list() {
        return sysWorkOrderTypeDao.list();
    }

    @Override
    public Map<String, Object> insert(SysWorkOrderType sysWorkOrderType) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人id
        sysWorkOrderType.setCreateId(sysUser.getId());
        //填入创建时间
        sysWorkOrderType.setCreateDate(new Date());
        //添加工单大类信息
        int insert = sysWorkOrderTypeDao.insert(sysWorkOrderType);
        if (insert >0){
            map.put("message","添加工单大类信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加工单大类信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoWorkOrderType findById(Integer id) {
        return sysWorkOrderTypeDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysWorkOrderType sysWorkOrderType) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人id
        sysWorkOrderType.setModifyId(sysUser.getId());
        //填入修改时间
        sysWorkOrderType.setModifyDate(new Date());
        //更新工单大类信息
        int update = sysWorkOrderTypeDao.update(sysWorkOrderType);
        if (update >0){
            map.put("message","更新工单大类信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新工单大类信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        map = new HashMap<>();
        try {
            //如果此工单已被引用，无法删除
            if (id == 1||id == 2||id == 3||id == 4){
                throw new RuntimeException("此工单已被引用，无法删除");
            }

            //先根据工单大类主键id删除工单类型明细信息
            sysWorkOrderTypeDetailDao.deleteByWorkOrderTypeId(id);

            //再删除工单类型信息
            int delete = sysWorkOrderTypeDao.delete(id);
            if (delete <= 0){
                throw new RuntimeException("删除工单大类失败");
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
        map.put("message","删除工单大类成功");
        map.put("status",true);
        return map;
    }
}
