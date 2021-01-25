package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindAllDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;
import com.api.vo.chargeManagement.VoPayResident;

import java.util.List;

public interface SysDailyPaymentDao {
    /**
     * 查询所有的日常缴费信息 （包含条件搜索）
     * @param searchDailyPayment 搜索条件
     * @return 日常缴费信息集合
     */
    List<VoDailyPayment> list(SearchDailyPayment searchDailyPayment);

    /**
     * 根据日常缴费主键id查询缴费信息
     * @param id 日常缴费主键id
     * @return 缴费信息
     */
    VoFindByIdDailyPayment findById(Integer id);

    /**
     * 查询所有的日常缴费信息
     * @return 日常缴费信息集合
     */
    List<VoFindAllDailyPayment> findAll();

    /**
     * 添加日常缴费订单信息（缴费）
     * @param dailyPaymentOrder 日常缴费订单信息
     * @return map
     */
    int insertOrder(DailyPaymentOrder dailyPaymentOrder);

    /**
     * 添加缴费订单信息后，修改缴费信息的已缴金额和待缴金额
     * @param updateDailyPayment 缴费信息修改信息
     * @return 影响行数
     */
    int updatePaidPriceAndPaymentPrice(UpdateDailyPayment updateDailyPayment);

    /**
     * 添加日常缴费信息,并返回主键id
     * @param dailyPayment 日常缴费信息
     * @return 影响行数
     */
    int insert(DailyPayment dailyPayment);

    /**
     * 根据缴费主键id查询缴费订单支付单号
     * @param id 缴费主键id
     * @return 缴费订单支付单号
     */
    String findOrderCodeBySDPI(Integer id);

    /**
     * 根据房产id查询待缴费人信息
     * @param id 房产id
     * @return 待缴费人信息
     */
    VoPayResident findResidentByEstateId(Integer id);

    /**
     * 添加缴费订单清单信息（缴费信息 与 缴费订单信息 关联表）
     * @param dailyPaymentOrderList 日常缴费订单清单信息
     * @return 影响行数
     */
    int insertOrderList(DailyPaymentOrderList dailyPaymentOrderList);
}
