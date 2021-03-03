package com.api.app.service.butler;

import com.api.model.app.*;

import java.util.Map;

public interface DecorationApplicationService {
    Map<String, Object> list(SearchAppDecoration searchAppDecoration);

    Map<String, Object> decorationCostDetail(Integer decorationId);

    Map<String, Object> applicationDecoration(UserIdAndEstateId userIdAndEstateId);

    Map<String, Object> update(AppUserDecoration userDecoration);

    Map<String, Object> findApplicationDecoration(Integer id);

    Map<String, Object> applicationPay(AppDepositManagement appDepositManagement);

    Map<String, Object> insertDecorationPerson(AppUserDecorationSubmit decorationSubmit);

    Map<String, Object> findDetailById(Integer decorationId);

    Map<String, Object> startDecoration(Integer decorationId, Integer id);
}
