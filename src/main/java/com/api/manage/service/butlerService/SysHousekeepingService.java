package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchHousekeeping;
import com.api.vo.butlerService.VoHousekeeping;

import java.util.List;

public interface SysHousekeepingService {
    List<VoHousekeeping> list(SearchHousekeeping searchHousekeeping);
}
