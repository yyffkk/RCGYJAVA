package com.api.manage.service.chargeManagement;

import com.api.model.alipay.SysAdvancePaymentOrder;
import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.model.chargeManagement.SearchAdvancePaymentDetail;
import com.api.model.chargeManagement.SysAdvancePaymentRefundRecord;
import com.api.vo.chargeManagement.VoAdvancePayment;
import com.api.vo.chargeManagement.VoAdvancePaymentDetail;

import java.util.List;
import java.util.Map;

public interface SysAdvancePaymentService {
    List<VoAdvancePayment> list(SearchAdvancePayment searchAdvancePayment);

    List<VoAdvancePaymentDetail> findDetailById(SearchAdvancePaymentDetail searchAdvancePaymentDetail);

    Map<String, Object> refund(SysAdvancePaymentRefundRecord sysAdvancePaymentRefundRecord);

    Map<String, Object> recharge(SysAdvancePaymentOrder sysAdvancePaymentOrder);
}
