package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchStationChange;
import com.api.model.businessManagement.SysStationChange;

import java.util.List;
import java.util.Map;

public interface SysStationChangeService {
    List<SysStationChange> list(SearchStationChange searchStationChange);

    Map<String, Object> insert(SysStationChange sysStationChange);

    Map<String, Object> delete(int[] ids);
}
