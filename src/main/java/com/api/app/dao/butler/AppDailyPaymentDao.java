package com.api.app.dao.butler;

import com.api.model.alipay.EstateIdAndAdvancePaymentPrice;
import com.api.model.app.AppDailyPaymentDetail;
import com.api.model.app.AppDailyPaymentOrder;
import com.api.model.chargeManagement.DailyPayment;
import com.api.model.chargeManagement.DailyPaymentOrderList;
import com.api.vo.app.*;

import java.math.BigDecimal;
import java.util.Date;
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
     * 根据缴费主键id查询当前缴费信息的缴费金额
     * @param id 缴费主键id
     * @return 当前缴费信息的缴费金额
     */
    BigDecimal findDailPaymentPriceById(int id);

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
     * 添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额（完全缴纳）
     * @param id 缴费主键id
     * @return 影响行数
     */
    int updatePaidPriceAndPaymentPrice(Integer id);

    /**
     * 添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额（部分缴纳）
     * @param dailyPaymentOrderList 日常缴费订单清单信息
     * @return 影响行数
     */
    int updatePaidPriceAndPaymentPrice2(DailyPaymentOrderList dailyPaymentOrderList);

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
     * @param estateId 房产id
     * @return 缴费记录集合信息
     */
    List<AppPaymentRecordVo> paymentRecord(Integer estateId);


    /**
     * 根据支付单号查询缴费订单信息
     * @param outTradeNo 支付单号
     * @return 缴费订单信息
     */
    AppDailyPaymentOrder findDailPaymentOrderByCode(String outTradeNo);

    /**
     * 根据支付单号更新订单状态
     * @param aliPaymentOrder 支付订单信息
     * @return 影响行数
     */
    int updateDPOrderStatusByCode(AppDailyPaymentOrder aliPaymentOrder);

    /**
     * 根据缴费订单支付单号查询缴费信息
     * @param outTradeNo 缴费订单支付单号
     * @return 缴费信息
     */
    List<AppDailyPaymentDetailsVo> findDailyPaymentIdsByOrderCode(String outTradeNo);

    /**
     * 查询未付款的订单
     * @return 未付款的订单信息
     */
    List<AppDailyPaymentOrder> findUnPaymentOrder();

    /**
     * 根据缴费主键id查询缴费信息
     * @param appDailyPaymentOrder app生活缴纳 支付订单信息
     * @return app 生活缴费详情Vo list 回显
     */
    List<AppDailyPaymentDetailsVo> findDailyPaymentByIds(AppDailyPaymentOrder appDailyPaymentOrder);

    /**
     * 修改缴费信息的已缴金额和待缴金额和滞纳金，并修改状态
     * @param appDailyPaymentDetailsVo app 生活缴费详情Vo list 回显
     * @return 影响行数
     */
    int updatePaidPAndPaymentPAndOverdueFine(AppDailyPaymentDetailsVo appDailyPaymentDetailsVo);

    /**
     * 根据房产id查询对应的预付款充值金额
     * @param estateId 房产id
     * @return 预付款充值金额
     */
    BigDecimal findAdvancePaymentPriceByEstateId(Integer estateId);

    /***
     * 查询缴费期限为今日的缴费记录
     * @param date 当前时间
     * @return 缴费记录
     */
    List<DailyPayment> findArrivePaymentTerm(Date date);

    /**
     * 根据房产主键id扣减预付款充值金额
     * @param estateIdAndAdvancePaymentPrice  房产id 和 预付款充值金额
     * @return 影响行数
     */
    int deductingAdvancePaymentByEstateId(EstateIdAndAdvancePaymentPrice estateIdAndAdvancePaymentPrice);

    /**
     * 查询三天后到达缴费期限的未缴纳缴费记录
     * @param threeDaysLater 三天后的时间
     * @return 缴费记录
     */
    List<DailyPayment> findThreeDaysLaterPayment(Date threeDaysLater);
}
