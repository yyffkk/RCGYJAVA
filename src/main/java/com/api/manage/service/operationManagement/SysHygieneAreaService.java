package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchHygieneArea;
import com.api.model.operationManagement.SysHygieneArea;
import com.api.vo.operationManagement.VoHygieneArea;

import java.util.List;
import java.util.Map;

public interface SysHygieneAreaService {
    List<VoHygieneArea> list(SearchHygieneArea searchHygieneArea);

    Map<String, Object> insert(SysHygieneArea sysHygieneArea);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysHygieneArea sysHygieneArea);

    Map<String, Object> delete(int[] ids);
}
