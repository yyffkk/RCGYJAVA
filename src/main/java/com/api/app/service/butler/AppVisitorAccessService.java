package com.api.app.service.butler;

import com.api.model.app.SearchVisitorAccess;
import com.api.model.butlerService.UserVisitors;
import com.api.vo.app.VisitorAccessVo;

import java.util.List;
import java.util.Map;

public interface AppVisitorAccessService {
    Map<String, Object> insertVisitorInfo(UserVisitors userVisitors);

    Map<String, Object> findVisitorByAC(Long accessCode);

    List<VisitorAccessVo> list(SearchVisitorAccess searchVisitorAccess);
}
