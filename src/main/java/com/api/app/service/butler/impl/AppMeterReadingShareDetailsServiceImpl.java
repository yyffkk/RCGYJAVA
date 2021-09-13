package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppMeterReadingShareDetailsDao;
import com.api.app.service.butler.AppMeterReadingShareDetailsService;
import com.api.model.app.EstateIdAndShareBillId;
import com.api.model.chargeManagement.SysMeterReadingShareBillDetails;
import com.api.vo.app.AppMeterShareDetailsVo;
import com.api.vo.app.AppMeterShareOrderVo;
import com.api.vo.app.AppMeterShareVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppMeterReadingShareDetailsServiceImpl implements AppMeterReadingShareDetailsService {
    private static Map<String,Object> map = null;
    @Resource
    AppMeterReadingShareDetailsDao appMeterReadingShareDetailsDao;

    @Override
    public Map<String,Object> findAllUnPayList(Integer estateId) {
        map = new HashMap<>();
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

                        //增加账单的滞纳缴纳金
                        appMeterShareVo.setTotal(appMeterShareVo.getTotal().add(lateFee));
                    }
                }
            }
        }
        map.put("message","请求成功");
        map.put("status",true);
        map.put("data",appMeterShareVos);
        return map;
    }

    @Override
    public List<AppMeterShareOrderVo> findAllMeterShareOrderByTel(String tel) {
        return appMeterReadingShareDetailsDao.findAllMeterShareOrderByTel(tel);
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
