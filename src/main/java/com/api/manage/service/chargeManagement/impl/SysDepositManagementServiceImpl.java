package com.api.manage.service.chargeManagement.impl;

import com.api.manage.dao.butlerService.UserDecorationDao;
import com.api.manage.dao.chargeManagement.SysDepositManagementDao;
import com.api.model.butlerService.UserDecoration;
import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.model.chargeManagement.SysDepositManagement;
import com.api.model.chargeManagement.SysDepositManagementOrder;
import com.api.model.businessManagement.SysUser;
import com.api.manage.service.chargeManagement.SysDepositManagementService;
import com.api.vo.chargeManagement.VoDepositManagement;
import com.api.vo.chargeManagement.VoFindByIdDepositManagement;
import com.api.vo.chargeManagement.VoRefundDecorationDetail;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysDepositManagementServiceImpl implements SysDepositManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysDepositManagementDao sysDepositManagementDao;
    @Resource
    UserDecorationDao userDecorationDao;

    @Override
    public List<VoDepositManagement> list(SearchDepositManagement searchDepositManagement) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchDepositManagement.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchDepositManagement.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchDepositManagement.setEstateNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchDepositManagement.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchDepositManagement.setRoomNumber(split[2]);
            }
        }
        List<VoDepositManagement> list = sysDepositManagementDao.list(searchDepositManagement);
        if (list != null && list.size()>0){
            for (VoDepositManagement voDepositManagement : list) {
                //根据押金管理主键id查询押金退款单号
                String code = sysDepositManagementDao.findOrderCodeByDMI(voDepositManagement.getId());
                voDepositManagement.setOrderCode(code);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> insert(SysDepositManagement sysDepositManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //当装修状态为未开始，根据房产id查询装修id
        Integer userDecorationId = userDecorationDao.findIdByEstateId(sysDepositManagement.getBuildingUnitEstateId());
        //填入装修id
        if (userDecorationId != null){
            sysDepositManagement.setUserDecorationId(userDecorationId);
        }else {
            map.put("message","该房产尚未提交装修信息");
            map.put("status",false);
            return map;
        }
        //根据装修id查询是否已有该房押金信息
        int count = sysDepositManagementDao.countByUDId(userDecorationId);
        if (count >0){
            map.put("message","此次装修押金已付");
            map.put("status",false);
            return map;
        }
        ///填入押金状态(初始为1.未退)
        sysDepositManagement.setStatus(1);
        //填入创建人
        sysDepositManagement.setCreateId(sysUser.getId());
        //填入创建时间
        sysDepositManagement.setCreateDate(new Date());
        //填入是否删除，0.删除，1.非删
        sysDepositManagement.setIsDelete(1);
        //添加押金管理信息
        int insert = sysDepositManagementDao.insert(sysDepositManagement);
        if (insert > 0){
            map.put("message","新增押金信息成功");
            map.put("status",true);
        }else {
            map.put("message","新增押金信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public VoFindByIdDepositManagement findById(Integer id) {
        return sysDepositManagementDao.findById(id);
    }

    @Override
    public Map<String, Object> update(SysDepositManagement sysDepositManagement) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        //填入修改人
        sysDepositManagement.setModifyId(sysUser.getId());
        //填入修改时间
        sysDepositManagement.setModifyDate(new Date());
        //修改押金管理
        int update = sysDepositManagementDao.update(sysDepositManagement);
        if (update >0){
            map.put("message","修改押金管理信息成功");
            map.put("status",true);
        }else {
            map.put("message","修改押金管理信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据押金管理主键id删除押金管理信息
                int update = sysDepositManagementDao.falseDelete(id);
                if (update <= 0){
                    throw new RuntimeException("删除押金管理信息失败");
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
        map.put("message","删除押金管理信息成功");
        map.put("status",true);
        return map;
    }

    @Override
    public VoRefundDecorationDetail refundDecorationDetail(Integer id) {
        return sysDepositManagementDao.refundDecorationDetail(id);
    }

    @Override
    @Transactional
    public Map<String, Object> refund(SysDepositManagementOrder sysDepositManagementOrder) {
        map = new HashMap<>();
        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        try {
            //根据装修主键id查询装修状态
            int status = userDecorationDao.findStatusById(sysDepositManagementOrder.getDecorationId());
            //如果装修状态不为 6.申请退款 则无法退款
            if (status != 6){
                throw new RuntimeException("当前装修状态不可退款");
            }

            //根据押金管理主键id查询该押金管理是否已有退款信息
            int count = sysDepositManagementDao.countOrderByDMI(sysDepositManagementOrder.getDepositManagementId());
            if (count >0 ){
                throw new RuntimeException("该押金管理已退款，无法再次退款");
            }
            //填入创建人
            sysDepositManagementOrder.setCreateId(sysUser.getId());
            //填入创建时间
            sysDepositManagementOrder.setCreateDate(new Date());
            //填入退款单号，支付宝退款单号
            sysDepositManagementOrder.setCode(UUID.randomUUID().toString().replaceAll("-",""));
            //填入退款时间
            sysDepositManagementOrder.setRefundDate(new Date());
            //添加押金退款单
            int insert = sysDepositManagementDao.refund(sysDepositManagementOrder);
            if (insert <=0){
                throw new RuntimeException("退款失败");
            }
            //根据押金管理主键id修改押金管理信息的状态 1.未退 --> 2.已退
            int update = sysDepositManagementDao.updateStatusById(sysDepositManagementOrder.getDepositManagementId());
            if (update <= 0){
                throw new RuntimeException("押金管理状态修改失败");
            }

            //修改装修状态，修改为 7.装修结束（已退押金）
            UserDecoration userDecoration = new UserDecoration();
            userDecoration.setId(sysDepositManagementOrder.getDecorationId());
            userDecoration.setStatus(7);
            userDecoration.setApplicationDate(new Date());
            int update2 = userDecorationDao.updateStatus(userDecoration);
            if (update2 <= 0){
                throw new RuntimeException("装修状态修改失败");
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
        map.put("message","退款成功");
        map.put("status",true);
        return map;
    }
}
