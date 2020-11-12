package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnit;
import com.aku.model.vo.VoCpmBuildingUnit;

import java.util.List;
import java.util.Map;

public interface CpmBuildingUnitService {
    List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit);

    Map<String, Object> insert(CpmBuildingUnit cpmBuildingUnit);

    CpmBuildingUnit findById(Integer id);

    Map<String, Object> update(CpmBuildingUnit cpmBuildingUnit);

    Map<String, Object> delete(Integer id);
}
