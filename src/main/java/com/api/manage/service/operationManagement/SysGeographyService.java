package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.GeographyInsert;
import com.api.model.operationManagement.GeographySearch;
import com.api.vo.operationManagement.SysGeographyVo;

import java.util.List;
import java.util.Map;

public interface SysGeographyService {
    List<SysGeographyVo> list(GeographySearch geographySearch);

    Map<String, Object> insert(GeographyInsert geographyInsert);

    Map<String, Object> findById(Integer geographyId);

    Map<String, Object> update(GeographyInsert geographyInsert);

    Map<String, Object> enable(Integer geographyId);

    Map<String, Object> delete(int[] ids);
}
