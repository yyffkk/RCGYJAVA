package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnit;
import com.aku.vo.basicArchives.VoCpmBuildingUnit;
import com.aku.vo.basicArchives.VoFindAll;

import java.util.List;
import java.util.Map;

public interface CpmBuildingUnitService {
    List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit);

    Map<String, Object> insert(CpmBuildingUnit cpmBuildingUnit);

    CpmBuildingUnit findById(Integer id);

    Map<String, Object> update(CpmBuildingUnit cpmBuildingUnit);

    Map<String, Object> delete(int[] ids);

    List<VoFindAll> findAll();
}
