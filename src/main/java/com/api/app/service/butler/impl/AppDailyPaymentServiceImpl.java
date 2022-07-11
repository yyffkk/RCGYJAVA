package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppDailyPaymentDao;
import com.api.app.dao.butler.AppMeterReadingShareDetailsDao;
import com.api.app.service.butler.AppDailyPaymentService;
import com.api.common.GetOverdueFine;
import com.api.model.app.AppDailyPaymentDetail;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.app.EstateIdAndShareBillId;
import com.api.model.chargeManagement.DailyPaymentOrderList;
import com.api.vo.app.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppDailyPaymentServiceImpl implements AppDailyPaymentService {
    @Resource
    AppDailyPaymentDao appDailyPaymentDao;
    @Resource
    AppMeterReadingShareDetailsDao appMeterReadingShareDetailsDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppDailyPaymentVo> list(Integer estateId) {
        //查询生活缴费信息list
        List<AppDailyPaymentVo> appDailyPaymentVos = appDailyPaymentDao.list(estateId);

        if (appDailyPaymentVos != null && appDailyPaymentVos.size()>0){
            for (AppDailyPaymentVo appDailyPaymentVo : appDailyPaymentVos) {
                AppDailyPaymentDetail appDailyPaymentDetail = new AppDailyPaymentDetail();
                //填入房产id
                appDailyPaymentDetail.setEstateId(estateId);
                //填入年份
                appDailyPaymentDetail.setYears(appDailyPaymentVo.getYears());
                //查询生活缴费明细类别信息
                List<AppDailyPaymentTypeVo> appDailyPaymentTypeVos = appDailyPaymentDao.listType(appDailyPaymentDetail);

                if (appDailyPaymentTypeVos != null && appDailyPaymentTypeVos.size()>0){
                    for (AppDailyPaymentTypeVo paymentTypeVo : appDailyPaymentTypeVos) {
                        //填入费用类型主键id
                        appDailyPaymentDetail.setChargesTemplateDetailId(paymentTypeVo.getId());
                        //查询生活缴费明细信息
                        List<AppDailyPaymentDetailedVo> appDailyPaymentDetailedVos = appDailyPaymentDao.listDetailed(appDailyPaymentDetail);

                        if (appDailyPaymentDetailedVos != null && appDailyPaymentDetailedVos.size()>0){
                            for (AppDailyPaymentDetailedVo detailedVo : appDailyPaymentDetailedVos) {
                                //填入年分组（1.上半年，2.下半年）
                                appDailyPaymentDetail.setGroupId(detailedVo.getGroupId());
                                //查询生活缴费详情信息
                                List<AppDailyPaymentDetailsVo> appDailyPaymentDetailsVos = appDailyPaymentDao.listDetails(appDailyPaymentDetail);

                                if (appDailyPaymentDetailsVos != null && appDailyPaymentDetailsVos.size()>0){

                                    for (AppDailyPaymentDetailsVo appDailyPaymentDetailsVo : appDailyPaymentDetailsVos) {
                                        //计算滞纳金
                                        appDailyPaymentDetailsVo = GetOverdueFine.getAppOverdueFine(appDailyPaymentDetailsVo);

                                        detailedVo.setOverdueFine(detailedVo.getOverdueFine().add(appDailyPaymentDetailsVo.getOverdueFine()));//半年的总滞纳金金额
                                        detailedVo.setDetailsVoList(appDailyPaymentDetailsVos);//app 生活缴费详情Vo list 回显

                                    }



                                }
                            }
                            paymentTypeVo.setDetailedVoList(appDailyPaymentDetailedVos);
                        }
                    }
                    appDailyPaymentVo.setDailyPaymentTypeVos(appDailyPaymentTypeVos);
                }
            }
        }
        return appDailyPaymentVos;
    }

    @Override
    @Transactional
    public Map<String, Object> pay(AppDailyPaymentOrder appDailyPaymentOrder) {
        map = new HashMap<>();
        try {
            int[] ids = appDailyPaymentOrder.getIds();
            //计算出所需支付总金额
            BigDecimal paymentPrice = appDailyPaymentDao.findPaymentPriceById(appDailyPaymentOrder);
            if (paymentPrice.compareTo(appDailyPaymentOrder.getPayPrice()) != 0){
                throw new RuntimeException("支付金额有误，请重新支付");
            }
            //填写付款金额
            appDailyPaymentOrder.setPayPrice(paymentPrice);

            //填写支付单号(正式为支付宝或微信返回的订单号)
            appDailyPaymentOrder.setCode(UUID.randomUUID().toString().replace("-","").trim());
            //填写创建人 app为-1
            appDailyPaymentOrder.setCreateId(-1);
            //填入创建时间
            appDailyPaymentOrder.setCreateDate(new Date());
            //添加缴费订单信息
            int i = appDailyPaymentDao.insertOrder(appDailyPaymentOrder);
            if (i<=0){
                throw new RuntimeException("添加缴费订单信息失败");
            }
            for (int id : ids) {
                //添加缴费订单清单信息（缴费信息 与 缴费订单信息 关联表）
                DailyPaymentOrderList dailyPaymentOrderList = new DailyPaymentOrderList();
                dailyPaymentOrderList.setDailyPaymentId(id);
                dailyPaymentOrderList.setDailyPaymentOrderId(appDailyPaymentOrder.getId());
                //根据缴费主键id查询当前缴费信息的缴费金额
                BigDecimal dailyPaymentPrice = appDailyPaymentDao.findDailPaymentPriceById(id);
                dailyPaymentOrderList.setDailyPaymentPrice(dailyPaymentPrice);
                int orderList = appDailyPaymentDao.insertOrderList(dailyPaymentOrderList);
                if (orderList <= 0){
                    throw new RuntimeException("添加缴费订单清单信息失败");
                }

                //添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额，并修改状态（完全缴纳）
                int update = appDailyPaymentDao.updatePaidPriceAndPaymentPrice(id);
                if (update <= 0){
                    throw new RuntimeException("修改缴费信息失败");
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
        map.put("message","支付成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findEstateIsPayment(Integer id) {
        map = new HashMap<>();
        List<AppDailPaymentChooseEstate> chooseEstateList = appDailyPaymentDao.findEstateIsPayment(id);
        map.put("data",chooseEstateList);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<Integer> findEstateIdByResidentId(Integer id) {
        return appDailyPaymentDao.findEstateIdByResidentId(id);
    }

    @Override
    public List<AppPaymentRecordVo> paymentRecord(Integer estateId) {
        return appDailyPaymentDao.paymentRecord(estateId);
    }

    @Override
    public Map<String, Object> findAdvancePaymentPriceByEstateId(Integer estateId) {
        map = new HashMap<>();
        
        BigDecimal advancePaymentPrice = appDailyPaymentDao.findAdvancePaymentPriceByEstateId(estateId);
        
        if (advancePaymentPrice == null){
            advancePaymentPrice = BigDecimal.ZERO;
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",advancePaymentPrice);
        
        return map;
    }

    @Override
    public Map<String, Object> findUnpaidAmount(Integer estateId) {
        map = new HashMap<>();



        //查询未缴日常费用
        BigDecimal unpaidDailyExpenses = BigDecimal.ZERO;
        //查询生活缴费信息list
        List<AppDailyPaymentVo> appDailyPaymentVos = appDailyPaymentDao.list(estateId);
        if (appDailyPaymentVos != null && appDailyPaymentVos.size()>0){
            for (AppDailyPaymentVo appDailyPaymentVo : appDailyPaymentVos) {
                AppDailyPaymentDetail appDailyPaymentDetail = new AppDailyPaymentDetail();
                //填入房产id
                appDailyPaymentDetail.setEstateId(estateId);
                //填入年份
                appDailyPaymentDetail.setYears(appDailyPaymentVo.getYears());
                //查询生活缴费明细类别信息
                List<AppDailyPaymentTypeVo> appDailyPaymentTypeVos = appDailyPaymentDao.listType(appDailyPaymentDetail);

                if (appDailyPaymentTypeVos != null && appDailyPaymentTypeVos.size()>0){
                    for (AppDailyPaymentTypeVo paymentTypeVo : appDailyPaymentTypeVos) {
                        //填入费用类型主键id
                        appDailyPaymentDetail.setChargesTemplateDetailId(paymentTypeVo.getId());
                        //查询生活缴费明细信息
                        List<AppDailyPaymentDetailedVo> appDailyPaymentDetailedVos = appDailyPaymentDao.listDetailed(appDailyPaymentDetail);

                        if (appDailyPaymentDetailedVos != null && appDailyPaymentDetailedVos.size()>0){
                            for (AppDailyPaymentDetailedVo detailedVo : appDailyPaymentDetailedVos) {
                                //填入年分组（1.上半年，2.下半年）
                                appDailyPaymentDetail.setGroupId(detailedVo.getGroupId());
                                //查询生活缴费详情信息
                                List<AppDailyPaymentDetailsVo> appDailyPaymentDetailsVos = appDailyPaymentDao.listDetails(appDailyPaymentDetail);

                                if (appDailyPaymentDetailsVos != null && appDailyPaymentDetailsVos.size()>0){

                                    for (AppDailyPaymentDetailsVo appDailyPaymentDetailsVo : appDailyPaymentDetailsVos) {
                                        //计算滞纳金
                                        appDailyPaymentDetailsVo = GetOverdueFine.getAppOverdueFine(appDailyPaymentDetailsVo);

                                        unpaidDailyExpenses = unpaidDailyExpenses.add(appDailyPaymentDetailsVo.getPaymentPrice().add(appDailyPaymentDetailsVo.getOverdueFine()));//添加未缴纳金额（包含滞纳金）

//                                        detailedVo.setOverdueFine(detailedVo.getOverdueFine().add(appDailyPaymentDetailsVo.getOverdueFine()));//半年的总滞纳金金额
//                                        detailedVo.setDetailsVoList(appDailyPaymentDetailsVos);//app 生活缴费详情Vo list 回显
                                    }
                                }
                            }
//                            paymentTypeVo.setDetailedVoList(appDailyPaymentDetailedVos);
                        }
                    }
//                    appDailyPaymentVo.setDailyPaymentTypeVos(appDailyPaymentTypeVos);
                }
            }
        }


        //查询未缴分摊费用
        BigDecimal unpaidAssessedExpenses = BigDecimal.ZERO;
        List<AppMeterShareVo> appMeterShareVos = appMeterReadingShareDetailsDao.findAllUnPayList(estateId);
        if (appMeterShareVos != null && appMeterShareVos.size()>0){
            for (AppMeterShareVo appMeterShareVo : appMeterShareVos) {
                EstateIdAndShareBillId estateIdAndShareBillId = new EstateIdAndShareBillId(estateId,appMeterShareVo.getId());
                List<AppMeterShareDetailsVo> appMeterShareDetailsVos = appMeterReadingShareDetailsDao.findUnPayShareDetailsById(estateIdAndShareBillId);
                if (appMeterShareDetailsVos != null && appMeterShareDetailsVos.size()>0){
                    appMeterShareVo.setAppMeterShareDetailsVos(appMeterShareDetailsVos);
                    for (AppMeterShareDetailsVo appMeterShareDetailsVo : appMeterShareDetailsVos) {
                        //增加滞纳金
                        BigDecimal lateFee = getLateFee(appMeterShareDetailsVo);
                        //添加账单详情的滞纳缴纳金
                        appMeterShareDetailsVo.setLateFree(lateFee);

                        unpaidAssessedExpenses = unpaidAssessedExpenses.add(appMeterShareDetailsVo.getLateFree().add(appMeterShareDetailsVo.getRemainingUnpaidAmount()));//添加未缴金额（包含滞纳金）
//                        //增加账单的滞纳缴纳金
//                        appMeterShareVo.setTotal(appMeterShareVo.getTotal().add(lateFee));
                    }
                }
            }
        }

        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",unpaidDailyExpenses.add(unpaidAssessedExpenses));
        return map;
    }

    private BigDecimal getLateFee(AppMeterShareDetailsVo shareBillDetails) {
        //逾期天数初始值0
        int expectedDays = 0;
        //滞纳金初始值0
        BigDecimal lateFee = BigDecimal.ZERO;

        if (shareBillDetails.getPaymentTime() != null){
            //已缴费，判断缴费时间是否大于缴费期限
            if (shareBillDetails.getPaymentTime().getTime() > shareBillDetails.getPaymentPeriod().getTime()){
                double d = (shareBillDetails.getPaymentTime().getTime() - shareBillDetails.getPaymentPeriod().getTime()) / 1000.0 / 60.0 / 60.0 / 24.0;
                //如果缴费时间大于缴费期限，有滞纳金，有逾期天数
                expectedDays = (int) Math.round(d);
                //计算滞纳金
                //(计算公式【未缴金额*（1+费率/100），每日累乘】)
                BigDecimal totalPrice = shareBillDetails.getRemainingUnpaidAmount();
                for (int i = 0; i < expectedDays; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    double rate = shareBillDetails.getRate().doubleValue();
                    //计算出总缴费金额
                    totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                }
                //滞纳金 = 总缴费金额 - 应缴金额
                lateFee = totalPrice.subtract(shareBillDetails.getRemainingUnpaidAmount());
            }else {
                //缴费时间小于缴费期限，滞纳金为0，逾期天数为0
            }
        }else {
            //未缴费，产生滞纳金
            if (new Date().getTime() > shareBillDetails.getPaymentPeriod().getTime()){
                double d = (new Date().getTime() - shareBillDetails.getPaymentPeriod().getTime()) / 1000.0 / 60.0 / 60.0 / 24.0;
                //当前时间大于缴费期限，有滞纳金，有逾期天数
                expectedDays = (int) Math.round(d);
                //计算滞纳金
                //(计算公式【未缴金额*（1+费率/100），每日累乘】)
                BigDecimal totalPrice = shareBillDetails.getRemainingUnpaidAmount();
                for (int i = 0; i < expectedDays; i++) {
                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                    double rate = shareBillDetails.getRate().doubleValue();
                    //计算出总缴费金额
                    totalPrice = totalPrice.multiply(new BigDecimal(1 + rate / 100));
                }
                //滞纳金 = 总缴费金额 - 应缴金额
                lateFee = totalPrice.subtract(shareBillDetails.getRemainingUnpaidAmount());
            }else {
                //当前时间小于缴费期限，滞纳金为0，逾期天数为0
            }
        }

        return lateFee.setScale(2,BigDecimal.ROUND_HALF_UP);
    }
}
