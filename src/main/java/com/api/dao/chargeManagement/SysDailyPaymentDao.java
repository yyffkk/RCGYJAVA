package com.api.dao.chargeManagement;

import com.api.model.chargeManagement.DailyPaymentOrder;
import com.api.model.chargeManagement.UpdateDailyPayment;
import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindAllDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
}
