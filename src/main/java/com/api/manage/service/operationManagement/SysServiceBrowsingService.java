package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchServiceBrowsing;
import com.api.model.operationManagement.SysServiceBrowsing;
import com.api.vo.operationManagement.VoServiceBrowsing;

import java.util.List;
import java.util.Map;

public interface SysServiceBrowsingService {
    List<VoServiceBrowsing> list(SearchServiceBrowsing searchServiceBrowsing);

    Map<String, Object> insert(SysServiceBrowsing sysServiceBrowsing);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysServiceBrowsing sysServiceBrowsing);

    Map<String, Object> delete(int[] ids);
}
