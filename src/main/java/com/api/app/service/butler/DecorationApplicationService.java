package com.api.app.service.butler;

import com.api.model.app.SearchAppDecoration;

import java.util.Map;

public interface DecorationApplicationService {
    Map<String, Object> list(SearchAppDecoration searchAppDecoration);

    Map<String, Object> decorationCostDetail();

}
