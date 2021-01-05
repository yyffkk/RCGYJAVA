package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.vo.chargeManagement.VoExpenseBill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SysExpenseBillService {
    List<VoExpenseBill> list(SearchDailyPayment searchDailyPayment);

    void export(HttpServletRequest request, HttpServletResponse response, List<VoExpenseBill> voExpenseBillList);
}
