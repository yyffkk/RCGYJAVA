package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchHousekeepingService;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;
import java.util.Map;

public interface SysHousekeepingServiceService {
    List<AppHousekeepingServiceVo> list(SearchHousekeepingService searchHousekeepingService);

    Map<String, Object> invalid(Integer housekeepingServiceId);
}
