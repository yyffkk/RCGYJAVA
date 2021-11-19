package com.api.app.service.butler;

import com.api.model.app.AppDailyPaymentOrder;
import com.api.vo.app.AppDailyPaymentVo;
import com.api.vo.app.AppPaymentRecordVo;

import java.util.List;
import java.util.Map;

public interface AppDailyPaymentService {
    List<AppDailyPaymentVo> list(Integer estateId);

    Map<String, Object> pay(AppDailyPaymentOrder appDailyPaymentOrder);

    Map<String, Object> findEstateIsPayment(Integer id);

    List<Integer> findEstateIdByResidentId(Integer id);

    List<AppPaymentRecordVo> paymentRecord(Integer estateId);

    Map<String, Object> findAdvancePaymentPriceByEstateId(Integer estateId);

    Map<String, Object> findUnpaidAmount(Integer estateId);
}
