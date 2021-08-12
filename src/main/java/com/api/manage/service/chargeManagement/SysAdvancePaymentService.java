package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.model.chargeManagement.SysAdvancePaymentRefundRecord;
import com.api.vo.chargeManagement.VoAdvancePayment;

import java.util.List;
import java.util.Map;

public interface SysAdvancePaymentService {
    List<VoAdvancePayment> list(SearchAdvancePayment searchAdvancePayment);

    Map<String, Object> findDetailById(Integer estateId);

    Map<String, Object> refund(SysAdvancePaymentRefundRecord sysAdvancePaymentRefundRecord);
}
