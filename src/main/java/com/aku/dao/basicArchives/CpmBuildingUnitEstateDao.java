package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.vo.basicArchives.VoFindAll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingUnitEstateDao {
    List<VoCpmBuildingUnitEstate> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate);

    int insert(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    CpmBuildingUnitEstate findById(Integer id);

    int update(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    int delete(Integer id);

    List<CpmBuildingUnitEstate> findByResidentId(Integer id);

    List<VoFindAll> findAll();
}
