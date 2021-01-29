package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppDailyPaymentDao;
import com.api.app.service.butler.AppDailyPaymentService;
import com.api.model.app.AppDailyPaymentDetail;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.chargeManagement.DailyPaymentOrderList;
import com.api.model.chargeManagement.UpdateDailyPayment;
import com.api.vo.app.AppDailyPaymentDetailedVo;
import com.api.vo.app.AppDailyPaymentDetailsVo;
import com.api.vo.app.AppDailyPaymentTypeVo;
import com.api.vo.app.AppDailyPaymentVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
                                    detailedVo.setDetailsVoList(appDailyPaymentDetailsVos);
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
    public Map<String, Object> paymentRecord(Integer id, String tel) {
        map = new HashMap<>();

        return map;
    }
}