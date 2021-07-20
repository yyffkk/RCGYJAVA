package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchHousekeepingService;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;

public interface SysHousekeepingServiceService {
    List<AppHousekeepingServiceVo> list(SearchHousekeepingService searchHousekeepingService);
}
