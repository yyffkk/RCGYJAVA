package com.api.manage.dao.chargeManagement;

import com.api.model.alipay.SysAdvancePaymentOrder;
import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.vo.chargeManagement.VoAdvancePayment;

import java.util.List;

public interface SysAdvancePaymentDao {
    /**
     * 查询预缴管理所有预缴信息（包含条件搜索）
     * @param searchAdvancePayment 预缴搜索条件
     * @return 所有预缴信息
     */
    List<VoAdvancePayment> list(SearchAdvancePayment searchAdvancePayment);

    /**
     * 根据房产主键Id查询最近充值订单时间
     * @param id 房产主键Id
     * @return 预充值支付订单
     */
    SysAdvancePaymentOrder findNearDateByEstateId(Integer id);
}
