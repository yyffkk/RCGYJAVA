package com.api.app.service.butler;

import com.api.model.butlerService.UserVisitors;

import java.util.Map;

public interface VisitorAccessService {
    Map<String, Object> insertVisitorInfo(UserVisitors userVisitors);

    Map<String, Object> findVisitorByAC(Long accessCode);
}
