package com.api.dao.chargeManagement;

import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoDailyPayment;

import java.util.List;

public interface SysDailyPaymentDao {
    List<VoDailyPayment> list(SearchDailyPayment searchDailyPayment);
}
