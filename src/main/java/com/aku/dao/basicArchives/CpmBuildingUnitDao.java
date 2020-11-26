package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnit;
import com.aku.vo.basicArchives.VoCpmBuildingUnit;
import com.aku.vo.basicArchives.VoFindAll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingUnitDao {
    List<VoCpmBuildingUnit> list(VoCpmBuildingUnit voCpmBuildingUnit);

    int insert(CpmBuildingUnit cpmBuildingUnit);

    CpmBuildingUnit findById(Integer id);

    int update(CpmBuildingUnit cpmBuildingUnit);

    int delete(Integer id);

    List<VoFindAll> findAll();

    List<VoFindAll> findByBuildingId(Integer id);

    CpmBuildingUnit findByNo(Integer no);
}
