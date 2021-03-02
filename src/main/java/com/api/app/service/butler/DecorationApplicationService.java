package com.api.app.service.butler;

import com.api.model.app.SearchAppDecoration;
import com.api.model.app.UserDecoration;
import com.api.model.app.UserIdAndEstateId;

import java.util.Map;

public interface DecorationApplicationService {
    Map<String, Object> list(SearchAppDecoration searchAppDecoration);

    Map<String, Object> decorationCostDetail();

    Map<String, Object> applicationDecoration(UserIdAndEstateId userIdAndEstateId);

    Map<String, Object> update(UserDecoration userDecoration);

    Map<String, Object> findApplicationDecoration(Integer id);
}
