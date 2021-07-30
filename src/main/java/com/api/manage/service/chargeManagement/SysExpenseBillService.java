package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchExpenseBill;
import com.api.model.chargeManagement.SearchExpenseBillDetail;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoExpenseBill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SysExpenseBillService {
    List<VoExpenseBill> list(SearchExpenseBill searchExpenseBill);

    void export(HttpServletRequest request, HttpServletResponse response, List<VoExpenseBill> voExpenseBillList);

    List<VoDailyPayment> detailList(SearchExpenseBillDetail searchExpenseBillDetail);
}
