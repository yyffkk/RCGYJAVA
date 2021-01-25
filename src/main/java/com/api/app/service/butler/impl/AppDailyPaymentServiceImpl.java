package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppDailyPaymentDao;
import com.api.app.service.butler.AppDailyPaymentService;
import com.api.model.app.AppDailyPaymentDetail;
import com.api.vo.app.AppDailyPaymentDetailedVo;
import com.api.vo.app.AppDailyPaymentDetailsVo;
import com.api.vo.app.AppDailyPaymentTypeVo;
import com.api.vo.app.AppDailyPaymentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppDailyPaymentServiceImpl implements AppDailyPaymentService {
    @Resource
    AppDailyPaymentDao appDailyPaymentDao;

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
}
