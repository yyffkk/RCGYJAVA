package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.UserResident;
import com.aku.model.vo.VoCpmBuildingUnitEstate;

import java.util.List;
import java.util.Map;

public interface CpmBuildingUnitEstateService {
    List<VoCpmBuildingUnitEstate> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate);

    Map<String, Object> insert(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    CpmBuildingUnitEstate findById(Integer id);

    Map<String,Object> updateOne(CpmBuildingUnitEstate cpmBuildingUnitEstate, UserResident userResident);

    Map<String, Object> updateOne(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    Map<String,Object> updateTwo(CpmBuildingUnitEstate cpmBuildingUnitEstate, UserResident userResident);

    Map<String, Object> delete(Integer id);
}
