package com.api.manage.service.basicArchives;

import com.api.model.basicArchives.CpmBuilding;
import com.api.vo.basicArchives.VoFindAll;

import java.util.List;
import java.util.Map;

public interface CpmBuildingService {
    List<CpmBuilding> list(CpmBuilding cpmBuilding);

    Map<String, Object> insert(CpmBuilding cpmBuilding);

    CpmBuilding findById(Integer id);

    Map<String, Object> update(CpmBuilding cpmBuilding);

    Map<String, Object> delete(int[] ids);

    List<VoFindAll> findAll();
}
