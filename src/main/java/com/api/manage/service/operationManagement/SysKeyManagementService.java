package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchKeyManagement;
import com.api.model.operationManagement.SysKeyManagement;
import com.api.vo.operationManagement.VoKeyManagement;

import java.util.List;
import java.util.Map;

public interface SysKeyManagementService {
    List<VoKeyManagement> list(SearchKeyManagement searchKeyManagement);

    Map<String, Object> insert(SysKeyManagement sysKeyManagement);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysKeyManagement sysKeyManagement);

    Map<String, Object> delete(int[] ids);
}
