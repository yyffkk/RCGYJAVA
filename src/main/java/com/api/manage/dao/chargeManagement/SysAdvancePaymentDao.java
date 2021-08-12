package com.api.manage.dao.chargeManagement;

import com.api.model.alipay.SysAdvancePaymentOrder;
import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.model.chargeManagement.SearchAdvancePaymentDetail;
import com.api.model.chargeManagement.SysAdvancePaymentRefundRecord;
import com.api.vo.chargeManagement.VoAdvancePayment;
import com.api.vo.chargeManagement.VoAdvancePaymentDetail;

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

    /**
     * 根据房产主键id查询预缴详情
     * @param searchAdvancePaymentDetail 预缴详情 搜索条件
     * @return 预缴详情
     */
    List<VoAdvancePaymentDetail> findDetailById(SearchAdvancePaymentDetail searchAdvancePaymentDetail);

    /**
     * 预缴退款
     * @param sysAdvancePaymentRefundRecord 预缴退款记录
     * @return 影响行数
     */
    int refund(SysAdvancePaymentRefundRecord sysAdvancePaymentRefundRecord);
}
