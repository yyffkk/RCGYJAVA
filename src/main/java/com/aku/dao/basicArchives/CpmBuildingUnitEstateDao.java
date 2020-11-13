package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.vo.VoCpmBuildingUnitEstate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingUnitEstateDao {
    List<VoCpmBuildingUnitEstate> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate);

    int insert(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    CpmBuildingUnitEstate findById(Integer id);

    int update(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    int delete(Integer id);
}
