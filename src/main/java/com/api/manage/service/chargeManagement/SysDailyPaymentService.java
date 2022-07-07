package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoDailyPayment;
import com.api.vo.chargeManagement.VoFindByIdDailyPayment;
import com.api.vo.chargeManagement.VoPayResident;

import java.util.List;
import java.util.Map;

public interface SysDailyPaymentService {
    List<VoDailyPayment> list(SearchDailyPayment searchDailyPayment);

    VoFindByIdDailyPayment findById(Integer id);

    Map<String, Object> push(DailyPaymentPush dailyPaymentPush);

    Map<String, Object> insertOrder(DailyPaymentPayInfo dailyPaymentPayInfo);

    Map<String, Object> insert(DailyPayment dailyPayment);

    VoPayResident findResidentByEstateId(Integer id);

    Map<String, Object> findEnableTempleDetail();

}
