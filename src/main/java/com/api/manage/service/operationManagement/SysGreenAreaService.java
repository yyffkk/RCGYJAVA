package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchGreenArea;
import com.api.model.operationManagement.SysGreenArea;
import com.api.vo.operationManagement.VoGreenArea;

import java.util.List;
import java.util.Map;

public interface SysGreenAreaService {
    List<VoGreenArea> list(SearchGreenArea searchGreenArea);

    Map<String, Object> insert(SysGreenArea sysGreenArea);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysGreenArea sysGreenArea);

    Map<String, Object> delete(int[] ids);
}
