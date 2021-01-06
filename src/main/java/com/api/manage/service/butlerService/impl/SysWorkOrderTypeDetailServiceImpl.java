package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysWorkOrderTypeDetailDao;
import com.api.model.butlerService.SysWorkOrderTypeDetail;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.butlerService.SysWorkOrderTypeDetailService;
import com.api.vo.butlerService.VoWorkOrderTypeDetail;
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
public class SysWorkOrderTypeDetailServiceImpl implements SysWorkOrderTypeDetailService {
    private static Map<String,Object> map = null;
    @Resource
    SysWorkOrderTypeDetailDao sysWorkOrderTypeDetailDao;

    @Override
    public List<VoWorkOrderTypeDetail> list(Integer id) {
        return sysWorkOrderTypeDetailDao.list(id);
    }

    @Override
    public Map<String, Object> insert(SysWorkOrderTypeDetail sysWorkOrderTypeDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入创建人id
        sysWorkOrderTypeDetail.setCreateId(sysUser.getId());
        //填入创建时间
        sysWorkOrderTypeDetail.setCreateDate(new Date());
        //添加工单类型明细信息
        int insert = sysWorkOrderTypeDetailDao.insert(sysWorkOrderTypeDetail);
        if(insert >0){
            map.put("message","添加工单类型明细信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加工单类型明细信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoWorkOrderTypeDetail findById(Integer id) {
        return sysWorkOrderTypeDetailDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysWorkOrderTypeDetail sysWorkOrderTypeDetail) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人id
        sysWorkOrderTypeDetail.setModifyId(sysUser.getId());
        //填入修改时间
        sysWorkOrderTypeDetail.setModifyDate(new Date());
        //更新工单类型明细信息
        int update = sysWorkOrderTypeDetailDao.update(sysWorkOrderTypeDetail);
        if (update >0){
            map.put("message","更新工单类型明细信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新工单类型明细信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length >0){
                for (int id : ids) {
                    //如果此工单明细已被引用，无法删除
//            this new RuntimeException("此工单明细已被引用，无法删除");

                    //删除工单类型明细
                    int delete = sysWorkOrderTypeDetailDao.delete(id);
                    if (delete <= 0){
                        throw new RuntimeException("删除工单类型明细信息失败");
                    }
                }
            }else {
                throw new RuntimeException("请选择至少一项工单类型明细信息");
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
        map.put("message","删除工单类型明细信息成功");
        map.put("status",true);
        return map;
    }
}
