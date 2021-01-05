package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysChargesTemplateDao;
import com.api.manage.dao.chargeManagement.SysChargesTemplateDetailDao;
import com.api.model.chargeManagement.ChargesTemplate;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.model.system.SysUser;
import com.api.manage.service.chargeManagement.SysChargesTemplateService;
import com.api.vo.chargeManagement.VoChargesTemplate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysChargesTemplateServiceImpl implements SysChargesTemplateService {
    private static Map<String,Object> map = null;
    @Resource
    SysChargesTemplateDao sysChargesTemplateDao;
    @Resource
    SysChargesTemplateDetailDao sysChargesTemplateDetailDao;

    @Override
    public List<VoChargesTemplate> list() {
        return sysChargesTemplateDao.list();
    }

    @Override
    @Transactional
    public Map<String, Object> insert(ChargesTemplate chargesTemplate) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //填入创建人
            chargesTemplate.setCreateId(sysUser.getId());
            //填入创建时间
            chargesTemplate.setCreateDate(new Date());
            //填入状态 0.未启用
            chargesTemplate.setStatus(0);
            //添加收费标准模版信息
            int insert = sysChargesTemplateDao.insert(chargesTemplate);
            if (insert <= 0){
                throw new RuntimeException("添加收费标准模版信息失败");
            }
            //添加默认的报事报修项目
            SysChargesTemplateDetail sysChargesTemplateDetail = new SysChargesTemplateDetail();
            //填入模版id
            sysChargesTemplateDetail.setChargesTemplateId(chargesTemplate.getId());
            //填入收费名称
            sysChargesTemplateDetail.setName("报事报修");
            //填入单价
            sysChargesTemplateDetail.setUnitPrice(BigDecimal.valueOf(200));
            //填入收费类型（1.元/月 平方米，2.元/ 立方米，3.元/ 次）
            sysChargesTemplateDetail.setType(3);
            //填入创建人
            sysChargesTemplateDetail.setCreateId(sysUser.getId());
            //填入创建日期
            sysChargesTemplateDetail.setCreateDate(new Date());
            //填入标记符 2.报事报修
            sysChargesTemplateDetail.setMarker(2);
            //添加默认的报事报修项目
            int insert1 = sysChargesTemplateDetailDao.insert(sysChargesTemplateDetail);
            if (insert1 <= 0){
                throw new RuntimeException("创建默认报事报修失败");
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
        map.put("message","添加收费标准模版信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            if (ids.length>0){
                for (int id : ids) {
                    //根据收费标准模版主键id删除收费标准模版信息
                    int delete = sysChargesTemplateDao.delete(id);
                    if (delete <= 0){
                        throw new RuntimeException("删除收费标准模版信息失败");
                    }
                }
            }else {
                throw new RuntimeException("请勾选要删除的版本");
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
        map.put("message","删除版本信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoChargesTemplate findById(Integer id) {
        return sysChargesTemplateDao.findById(id);
    }

    @Override
    public Map<String, Object> update(ChargesTemplate chargesTemplate) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人
        chargesTemplate.setModifyId(sysUser.getId());
        //填入修改时间
        chargesTemplate.setModifyDate(new Date());
        //更新收费标准模版信息
        int update = sysChargesTemplateDao.update(chargesTemplate);
        if (update >0){
            map.put("message","更新收费标准模版信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新收费标准模版信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> enable(Integer id) {
        map = new HashMap<>();
        try {
            //先禁用所有的物业收费标准模版
            sysChargesTemplateDao.disableAll();
            //根据物业收费标准模版主键id启用物业收费标准模版
            int update2 = sysChargesTemplateDao.enable(id);
            if (update2 <= 0){
                throw new RuntimeException("启用收费标准模版失败");
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
        map.put("message","启用收费标准模版成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> disable(Integer id) {
        map = new HashMap<>();
        int update = sysChargesTemplateDao.disable(id);
        if (update >0){
            map.put("message","禁用收费标准模版成功");
            map.put("status",true);
        }else {
            map.put("message","禁用收费标准模版失败");
            map.put("status",false);
        }
        return map;
    }
}
