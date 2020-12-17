package com.api.service.chargeManagement;

import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoDailyPayment;

import java.util.List;

public interface SysDailyPaymentService {
    List<VoDailyPayment> list(SearchDailyPayment searchDailyPayment);
}
