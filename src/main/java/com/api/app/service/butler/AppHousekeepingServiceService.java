package com.api.app.service.butler;

import com.api.model.app.AppHousekeepingService;
import com.api.model.app.SearchAppHousekeepingService;
import com.api.model.app.UserIdAndHousekeepingServiceId;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;
import java.util.Map;

public interface AppHousekeepingServiceService {
    Map<String, Object> submitHousekeeping(AppHousekeepingService appHousekeepingService);

    List<AppHousekeepingServiceVo> list(SearchAppHousekeepingService searchAppHousekeepingService);

    Map<String, Object> findHousekeepingProcessRecord(Integer housekeepingServiceId);

    Map<String, Object> cancel(UserIdAndHousekeepingServiceId userIdAndHousekeepingServiceId);

    Map<String, Object> evaluation(AppHousekeepingService appHousekeepingService);
}
