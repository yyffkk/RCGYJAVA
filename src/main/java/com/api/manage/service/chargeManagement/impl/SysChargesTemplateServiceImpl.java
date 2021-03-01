package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.chargeManagement.SysChargesTemplateDao;
import com.api.manage.dao.chargeManagement.SysChargesTemplateDetailDao;
import com.api.model.chargeManagement.ChargesTemplate;
import com.api.model.chargeManagement.SysChargesTemplateAdditionalCost;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.chargeManagement.SysChargesTemplateService;
import com.api.vo.chargeManagement.VoChargesTemplate;
import com.api.vo.chargeManagement.VoChargesTemplateAdditionalCost;
import com.api.vo.chargeManagement.VoFindByIdChargesTemplateDetail;
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
            //查询创建时间最近的物业收费标准模版的明细信息集合
            List<VoFindByIdChargesTemplateDetail> chargesTemplateDetailList = sysChargesTemplateDao.findChargesTemplateFromNow();
            //添加物业收费标准模版信息
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
            //判断是否有默认模版
            if (chargesTemplateDetailList != null && chargesTemplateDetailList.size()>0){
                for (VoFindByIdChargesTemplateDetail templateDetail : chargesTemplateDetailList) {
                    //添加默认的物业收费标准明细信息
                    SysChargesTemplateDetail sysChargesTemplateDetail = new SysChargesTemplateDetail();
                    //填入模版id
                    sysChargesTemplateDetail.setChargesTemplateId(chargesTemplate.getId());
                    //填入收费名称
                    sysChargesTemplateDetail.setName(templateDetail.getName());
                    //填入状态（1.启用，0.未启用）
                    sysChargesTemplateDetail.setStatus(templateDetail.getStatus());
                    //填入单价
                    sysChargesTemplateDetail.setUnitPrice(templateDetail.getUnitPrice());
                    //填入收费类型（1.元/月 平方米，2.元/ 立方米，3.元/ 次）
                    sysChargesTemplateDetail.setType(templateDetail.getType());
                    //填入创建人
                    sysChargesTemplateDetail.setCreateId(sysUser.getId());
                    //填入创建日期
                    sysChargesTemplateDetail.setCreateDate(new Date());
                    //填入标记符【费用类型名称】（1.物业管理费，2.维修费（报事报修 唯一）,3.装修押金（装修押金 唯一），4.活动报名费）
                    sysChargesTemplateDetail.setMarker(templateDetail.getMarker());
                    //添加默认的物业收费标准明细信息
                    int insert1 = sysChargesTemplateDetailDao.insert(sysChargesTemplateDetail);
                    if (insert1 <= 0){
                        throw new RuntimeException("创建默认标准明细信息失败");
                    }

                    //查询对应的物业收费标准附加费用信息集合
                    List<VoChargesTemplateAdditionalCost> additionalCostById = sysChargesTemplateDetailDao.findAdditionalCostById(templateDetail.getId());
                    if (additionalCostById != null && additionalCostById.size()>0){
                        for (VoChargesTemplateAdditionalCost additionalCostVo : additionalCostById) {
                            //添加默认的物业收费标准附加费用信息
                            SysChargesTemplateAdditionalCost additionalCost = new SysChargesTemplateAdditionalCost();
                            additionalCost.setChargesTemplateDetailId(sysChargesTemplateDetail.getId());
                            additionalCost.setName(additionalCostVo.getName());
                            additionalCost.setCost(additionalCostVo.getCost());
                            int insert2 = sysChargesTemplateDetailDao.insertAdditionCost(additionalCost);
                            if (insert2 <= 0){
                                throw new RuntimeException("创建默认标准附加费用信息失败");
                            }
                        }
                    }
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
        map.put("message","添加收费标准模版信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据收费标准模版主键id查询状态信息（1.启用，0.未启用）
                int status = sysChargesTemplateDao.findStatusById(id);
                if (status == 1){
                    throw new RuntimeException("该模版已启用,无法删除");
                }
                //根据收费标准模版主键id查询收费标准明细id集合
                List<Integer> chargesTemplateDetailIds = sysChargesTemplateDetailDao.findCTDIdByCTId(id);
                //查询日常缴费是否存在关联收费标准
                //查询押金管理是否存在关联收费标准

                //根据收费标准模版主键id删除收费标准模版信息
                int delete = sysChargesTemplateDao.delete(id);
                if (delete <= 0){
                    throw new RuntimeException("删除收费标准模版信息失败");
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
    @Transactional
    public Map<String, Object> isEnable(Integer id) {
        map = new HashMap<>();
        //根据物业收费标准模版主键id查询状态（1.启用，0.未启用）
        int status = sysChargesTemplateDao.findStatusById(id);
        try {
            if (status == 1){
                //禁用
                int update = sysChargesTemplateDao.disable(id);
                if (update <= 0){
                    throw new RuntimeException("禁用收费标准模版失败");
                }
            }else {
                //启用
                //先禁用所有的物业收费标准模版
                sysChargesTemplateDao.disableAll();
                //根据物业收费标准模版主键id启用物业收费标准模版
                int update2 = sysChargesTemplateDao.enable(id);
                if (update2 <= 0){
                    throw new RuntimeException("启用收费标准模版失败");
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
        if (status == 1){
            map.put("message","禁用收费标准模版成功");
        }else {
            map.put("message","启用收费标准模版成功");
        }
        map.put("status",true);
        return map;
    }
}
