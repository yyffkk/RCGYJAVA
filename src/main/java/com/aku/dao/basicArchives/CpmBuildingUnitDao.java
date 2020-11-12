package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnit;
import com.aku.model.vo.VoCpmBuildingUnit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CpmBuildingUnitDao {
    List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit);

    int insert(CpmBuildingUnit cpmBuildingUnit);

    CpmBuildingUnit findById(Integer id);

    int update(CpmBuildingUnit cpmBuildingUnit);

    int delete(Integer id);
}
