package com.api.manage.service.chargeManagement.impl;

import com.api.app.dao.butler.AppDailyPaymentDao;
import com.api.manage.dao.chargeManagement.SysAdvancePaymentDao;
import com.api.manage.service.chargeManagement.SysAdvancePaymentService;
import com.api.model.alipay.EstateIdAndAdvancePaymentPrice;
import com.api.model.alipay.SysAdvancePaymentOrder;
import com.api.model.businessManagement.SysUser;
import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.model.chargeManagement.SearchAdvancePaymentDetail;
import com.api.model.chargeManagement.SysAdvancePaymentRefundRecord;
import com.api.vo.chargeManagement.VoAdvancePayment;
import com.api.vo.chargeManagement.VoAdvancePaymentDetail;
import org.apache.commons.lang3.StringUtils;
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
public class SysAdvancePaymentServiceImpl implements SysAdvancePaymentService {
    private static Map<String,Object> map = null;
    @Resource
    SysAdvancePaymentDao sysAdvancePaymentDao;
    @Resource
    AppDailyPaymentDao appDailyPaymentDao;

    @Override
    public List<VoAdvancePayment> list(SearchAdvancePayment searchAdvancePayment) {
        //初始化数组参数，长度为3，值都为null
        String[] split = {null,null,null};
        if (searchAdvancePayment.getRoomName()!=null){
            //用'-'截取字符串 获取数组
            String[] split2 = searchAdvancePayment.getRoomName().replace(" ", "").split("-");
            //如果数组长度超过3，超出部分不要
            for (int i =0;i<split2.length;i++) {
                //防止下标越界异常
                if (i<3){
                    split[i] = split2[i];
                }
            }
            //添加楼栋模糊查询信息,StringUtils.isNotBlank()【null，''】为true【' ','a',' a '】为false
            if (StringUtils.isNotBlank(split[0])){
                searchAdvancePayment.setBuildingNo(Integer.valueOf(split[0]));
            }
            //添加单元模糊查询信息
            if (StringUtils.isNotBlank(split[1])) {
                searchAdvancePayment.setUnitNo(Integer.valueOf(split[1]));
            }
            //添加房产模糊查询信息
            if (StringUtils.isNotBlank(split[2])) {
                searchAdvancePayment.setRoomNumber(split[2]);
            }
        }

        List<VoAdvancePayment> list = sysAdvancePaymentDao.list(searchAdvancePayment);

        if (list != null && list.size()>0){
            for (VoAdvancePayment voAdvancePayment : list) {
                //填入最近充值时间
                //根据房产主键Id查询最近充值订单时间
                SysAdvancePaymentOrder sysAdvancePaymentOrder = sysAdvancePaymentDao.findNearDateByEstateId(voAdvancePayment.getId());
                if (sysAdvancePaymentOrder != null){
                    voAdvancePayment.setNearDate(sysAdvancePaymentOrder.getCreateDate());
                }
            }
        }
        return list;
    }

    @Override
    public List<VoAdvancePaymentDetail> findDetailById(SearchAdvancePaymentDetail searchAdvancePaymentDetail) {
        return sysAdvancePaymentDao.findDetailById(searchAdvancePaymentDetail);
    }

    @Override
    @Transactional
    public Map<String, Object> refund(SysAdvancePaymentRefundRecord sysAdvancePaymentRefundRecord) {
        map = new HashMap<>();


        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            sysAdvancePaymentRefundRecord.setCreateId(sysUser.getId());//填入创建人
            sysAdvancePaymentRefundRecord.setCreateDate(new Date());//填入创建时间
            sysAdvancePaymentRefundRecord.setRefundType(1);//1.线下


            //根据房产id查询对应的预付款充值金额
            BigDecimal advancePaymentPrice = appDailyPaymentDao.findAdvancePaymentPriceByEstateId(sysAdvancePaymentRefundRecord.getEstateId());
            if (advancePaymentPrice == null){
                throw new RuntimeException("预付款充值金额余额不足");
            }

            if (advancePaymentPrice.compareTo(sysAdvancePaymentRefundRecord.getRefundPrice()) < 0){
                throw new RuntimeException("预付款充值金额余额不足");
            }

            //预缴退款
            int insert = sysAdvancePaymentDao.refund(sysAdvancePaymentRefundRecord);
            if (insert <=0 ){
                throw new RuntimeException("退款失败");
            }

            //修改
            EstateIdAndAdvancePaymentPrice estateIdAndAdvancePaymentPrice = new EstateIdAndAdvancePaymentPrice();
            estateIdAndAdvancePaymentPrice.setEstateId(sysAdvancePaymentRefundRecord.getEstateId());//填入房产主键id
            estateIdAndAdvancePaymentPrice.setAdvancePaymentPrice(sysAdvancePaymentRefundRecord.getRefundPrice());//填入退款金额
            int update = appDailyPaymentDao.deductingAdvancePaymentByEstateId(estateIdAndAdvancePaymentPrice);
            if (update <= 0){
                throw new RuntimeException("退款失败");
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
        map.put("message","退款成功");
        map.put("status",true);
        return map;
    }
}
