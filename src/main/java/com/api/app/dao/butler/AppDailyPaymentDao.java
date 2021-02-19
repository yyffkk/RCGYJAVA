package com.api.app.dao.butler;

import com.api.model.app.AppDailyPaymentDetail;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.chargeManagement.DailyPaymentOrderList;
import com.api.vo.app.*;

import java.math.BigDecimal;
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

    /**
     * 根据缴费主键id查询所需支付总金额
     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
     * @return 待缴金额
     */
    BigDecimal findPaymentPriceById(AppDailyPaymentOrder appDailyPaymentOrder);

    /**
     * 添加生活缴费订单信息
     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
     * @return 影响行数
     */
    int insertOrder(AppDailyPaymentOrder appDailyPaymentOrder);

    /**
     * 添加缴费订单清单信息（缴费信息 与 缴费订单信息 关联表）
     * @param dailyPaymentOrderList 日常缴费订单清单信息
     * @return 影响行数
     */
    int insertOrderList(DailyPaymentOrderList dailyPaymentOrderList);

    /**
     * 添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额
     * @param id 缴费主键id
     * @return 影响行数
     */
    int updatePaidPriceAndPaymentPrice(Integer id);

    /**
     * 根据当前用户id查询房产缴费信息
     * @param id 用户id
     * @return app 日常缴费选择房屋信息
     */
    List<AppDailPaymentChooseEstate> findEstateIsPayment(Integer id);

    /**
     * 根据住户id查询房产id集合
     * @param id 住户id
     * @return 房产id集合
     */
    List<Integer> findEstateIdByResidentId(Integer id);

    /**
     * 缴费记录
     * @param estateIds 房产id集合
     * @return 缴费记录集合信息
     */
    List<AppPaymentRecordVo> paymentRecord(List<Integer> estateIds);
}
