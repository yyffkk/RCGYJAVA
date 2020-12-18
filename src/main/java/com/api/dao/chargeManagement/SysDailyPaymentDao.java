package com.api.dao.chargeManagement;

import com.api.model.remind.SysMessage;
import com.api.model.remind.SysSending;
import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;

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
}
