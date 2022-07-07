package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoWorkOrderCost;

import java.util.List;

public interface SysWorkOrderCostDao {
    /**
     * 查询所有的工单费用信息 （包含条件搜索）
     * @param searchDailyPayment 搜索条件
     * @return 工单费用信息集合
     */
    List<VoWorkOrderCost> list(SearchDailyPayment searchDailyPayment);

    /**
     * 批量假删除缴费信息
     * @param id 缴费主键id
     * @return 影响行数
     */
    int falseDelete(int id);
}
