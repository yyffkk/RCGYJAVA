package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.SearchExpenseBill;
import com.api.vo.chargeManagement.VoExpenseBill;

import java.util.List;

public interface SysExpenseBillDao {
    /**
     * 查询所有的费用账单信息 （包含条件搜索）
     * @param searchExpenseBill 搜索条件
     * @return map
     */
    List<VoExpenseBill> list(SearchExpenseBill searchExpenseBill);

    /**
     * 根据状态显示value值 查询状态显示name名称
     * @param status 状态显示value值
     * @return 状态显示name名称
     */
    String findStatusSNBySV(Integer status);
}
