package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppDailyPaymentDao;
import com.api.app.service.butler.AppDailyPaymentService;
import com.api.model.app.AppDailyPaymentDetail;
import com.api.model.app.AppDailyPaymentOrder;
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
                                        //计算出滞纳金
                                        if (appDailyPaymentDetailsVo.getStatus() != 3){//3.全部缴纳
                                            //当不为全部缴纳时，滞纳金需要计算，否则取数据库的滞纳金
                                            Date paymentTerm = appDailyPaymentDetailsVo.getPaymentTerm();
                                            Date date = new Date();
                                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                            if (df.format(date).compareTo(df.format(paymentTerm)) > 0){
                                                //当前时间超过缴费期限(计算公式【总支付金额 = 代缴金额*（1+费率/100），每月累乘】)
                                                Calendar calendar = Calendar.getInstance();
                                                calendar.clear();
                                                calendar.setTime(paymentTerm);
                                                //缴纳期限的年份
                                                int paymentTermYear = calendar.get(Calendar.YEAR);
                                                //缴纳期限的月份
                                                int paymentTermMonth = calendar.get(Calendar.MONTH)+1;
                                                //缴纳期限的日期
                                                int paymentTermDay = calendar.get(Calendar.DAY_OF_MONTH);
                                                calendar.clear();
                                                calendar.setTime(date);
                                                //当前的年份
                                                int dateYear = calendar.get(Calendar.YEAR);
                                                //当前的月份
                                                int dateMonth = calendar.get(Calendar.MONTH)+1;
                                                //当前的日期
                                                int dateDay = calendar.get(Calendar.DAY_OF_MONTH);

                                                //计算相差多少个月
                                                int betweenMonth = Math.abs((dateYear-paymentTermYear)*12+(dateMonth - paymentTermMonth));
                                                if (dateDay > paymentTermDay){
                                                    //当 当前时间日期 大于 缴纳期限时日期 时，月份+1
                                                    betweenMonth = betweenMonth +1;
                                                }

                                                //计算出 支付总金额【待缴金额+滞纳金】
                                                BigDecimal totalPrice = appDailyPaymentDetailsVo.getPaymentPrice();
                                                //(计算公式【待缴金额*（1+费率/100），每月累乘】)
                                                for (int i = 0; i < betweenMonth; i++) {
                                                    //需要先转化成double，不然int类型之间的计算结果会被默认转换成int
                                                    Double rate = Double.valueOf(appDailyPaymentDetailsVo.getRate());
                                                    totalPrice = totalPrice.multiply(new BigDecimal(1+rate/100));
                                                }
                                                //滞纳金 = 支付总金额 - 代缴金额
                                                BigDecimal overdueFine = totalPrice.setScale(2, RoundingMode.HALF_UP).subtract(appDailyPaymentDetailsVo.getPaymentPrice());
                                                appDailyPaymentDetailsVo.setOverdueFine(overdueFine);
                                            }else {
                                                //当前时间不超过缴费期限,滞纳金为0
                                                appDailyPaymentDetailsVo.setOverdueFine(BigDecimal.ZERO);
                                            }
                                            //半年的总滞纳金金额
                                            detailedVo.setOverdueFine(detailedVo.getOverdueFine().add(appDailyPaymentDetailsVo.getOverdueFine()));
                                        }
                                        detailedVo.setDetailsVoList(appDailyPaymentDetailsVos);

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

                //添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额，并修改状态
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
    public List<AppPaymentRecordVo> paymentRecord(List<Integer> estateIds) {
        return appDailyPaymentDao.paymentRecord(estateIds);
    }




}
