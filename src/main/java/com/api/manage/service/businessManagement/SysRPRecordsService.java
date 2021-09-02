package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchRPRecords;
import com.api.model.businessManagement.SysRPRecords;

import java.util.List;
import java.util.Map;

public interface SysRPRecordsService {
    List<SysRPRecords> list(SearchRPRecords searchRPRecords);

    Map<String, Object> insert(SysRPRecords sysRPRecords);

    Map<String, Object> delete(int[] ids);
}
