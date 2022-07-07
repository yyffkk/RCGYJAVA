package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchGreenTask;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.operationManagement.VoGreenTask;

import java.util.List;
import java.util.Map;

public interface SysGreenTaskService {
    List<VoGreenTask> list(SearchGreenTask searchGreenTask);

    Map<String, Object> insert(SysGreenTask sysGreenTask);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> findCheckSituationByGreenTaskId(Integer greenTaskId);
}
