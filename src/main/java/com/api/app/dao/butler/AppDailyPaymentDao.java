package com.api.app.dao.butler;

import com.api.model.app.AppDailyPaymentDetail;
import com.api.vo.app.AppDailyPaymentDetailedVo;
import com.api.vo.app.AppDailyPaymentDetailsVo;
import com.api.vo.app.AppDailyPaymentTypeVo;
import com.api.vo.app.AppDailyPaymentVo;

import java.util.List;

public interface AppDailyPaymentDao {
    /**
     * 查询生活缴费信息list
     * @param estateId 用户房产id
     * @return app 生活缴费Vo list 回显
     */
    List<AppDailyPaymentVo> list(Integer estateId);

    /**
     * 查询生活缴费明细类别信息list
     * @param estateIdAndYears 房产id 和 年份
     * @return 生活缴费类别明细Vo list 回显
     */
    List<AppDailyPaymentTypeVo> listType(AppDailyPaymentDetail estateIdAndYears);

    /**
     * 查询生活缴费明细信息list
     * @param estateIdAndYearsAndCTDI 房产id 和 年份 和 费用名称类型
     * @return app 生活缴费明细Vo list 回显
     */
    List<AppDailyPaymentDetailedVo> listDetailed(AppDailyPaymentDetail estateIdAndYearsAndCTDI);

    /**
     * 查询生活缴费详情信息list
     * @param appDailyPaymentDetail 生活缴费详情条件
     * @return app 生活缴费详情Vo list 回显
     */
    List<AppDailyPaymentDetailsVo> listDetails(AppDailyPaymentDetail appDailyPaymentDetail);
}
