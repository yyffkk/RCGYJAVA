package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.DailyPayment;
import com.api.model.chargeManagement.SearchExpenseBill;
import com.api.model.chargeManagement.SearchExpenseBillDetail;
import com.api.vo.chargeManagement.VoExpenseBill;
import com.api.vo.chargeManagement.VoExpenseBillDetail;

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

    /**
     * 查询费用账单的所有详情信息
     * @param searchExpenseBillDetail 费用账单详情搜索条件
     * @return 费用账单的所有详情信息
     */
    List<VoExpenseBillDetail> detailList(SearchExpenseBillDetail searchExpenseBillDetail);

    /**
     * 根据缴费主键id查询缴费人名称
     * @param id 缴费主键id
     * @return 缴费人名称
     */
    String findPayPeopleNameByBillId(Integer id);

    /**
     * 根据房产主键id查询当前关联住户
     * @param id 房产主键id
     * @return 当前关联住户
     */
    String findAssociationResidentsByEstateId(Integer id);

    /**
     * 费用账单退款接口
     * @param dailyPayment 日常缴费 信息model
     * @return 影响行数
     */
    int refund(DailyPayment dailyPayment);
}
