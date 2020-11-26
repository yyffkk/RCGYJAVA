package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmBuilding;
import com.aku.vo.basicArchives.VoFindAll;

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