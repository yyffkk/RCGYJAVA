package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchRegulationManagement;
import com.api.model.operationManagement.SysRegulationManagement;
import com.api.vo.operationManagement.VoRegulationManagement;

import java.util.List;
import java.util.Map;

public interface SysRegulationManagementService {
    List<VoRegulationManagement> list(SearchRegulationManagement searchRegulationManagement);

    Map<String, Object> insert(SysRegulationManagement sysRegulationManagement);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysRegulationManagement sysRegulationManagement);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> release(Integer id);
}
