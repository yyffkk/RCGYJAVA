package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchAdvancePayment;
import com.api.vo.chargeManagement.VoAdvancePayment;

import java.util.List;

public interface SysAdvancePaymentService {
    List<VoAdvancePayment> list(SearchAdvancePayment searchAdvancePayment);
}
