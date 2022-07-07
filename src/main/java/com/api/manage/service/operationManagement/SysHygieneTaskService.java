package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SysHygieneTask;
import com.api.model.operationManagement.SearchHygieneTask;
import com.api.vo.operationManagement.VoHygieneTask;

import java.util.List;
import java.util.Map;

public interface SysHygieneTaskService {
    List<VoHygieneTask> list(SearchHygieneTask searchHygieneTask);

    Map<String, Object> insert(SysHygieneTask sysHygieneTask);

    Map<String, Object> findById(Integer id);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> findCheckSituationByHygieneTaskId(Integer hygieneTaskId);
}
