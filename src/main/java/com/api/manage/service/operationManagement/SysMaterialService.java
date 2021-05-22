package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchMaterial;
import com.api.model.operationManagement.SysMaterial;
import com.api.vo.operationManagement.VoMaterial;

import java.util.List;
import java.util.Map;

public interface SysMaterialService {
    List<VoMaterial> list(SearchMaterial searchMaterial);

    Map<String, Object> insert(SysMaterial sysMaterial);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> update(SysMaterial sysMaterial);
}
