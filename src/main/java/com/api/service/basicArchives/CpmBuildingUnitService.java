package com.api.service.basicArchives;

import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.vo.basicArchives.VoCpmBuildingUnit;
import com.api.vo.basicArchives.VoFindAll;

import java.util.List;
import java.util.Map;

public interface CpmBuildingUnitService {
    List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit);

    Map<String, Object> insert(CpmBuildingUnit cpmBuildingUnit);

    CpmBuildingUnit findById(Integer id);

    Map<String, Object> update(CpmBuildingUnit cpmBuildingUnit);

    Map<String, Object> delete(int[] ids);

    List<VoFindAll> findAll();

    List<VoFindAll> findByBuildingId(Integer id);
}
