package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmBuildingUnitEstate;
import com.aku.model.basicArchives.EstateAndResidentList;
import com.aku.model.basicArchives.UserResident;
import com.aku.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.aku.vo.basicArchives.VoFindAll;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CpmBuildingUnitEstateService {
    List<VoCpmBuildingUnitEstate> list(VoCpmBuildingUnitEstate voCpmBuildingUnitEstate);

    Map<String, Object> insert(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    Map<String, Object> insert(List<UserResident> userResidentList, CpmBuildingUnitEstate cpmBuildingUnitEstate);

    CpmBuildingUnitEstate findById(Integer id);

    Map<String, Object> delete(Integer id);

    List<VoFindAll> findAll();

    Map<String, Object> update(EstateAndResidentList estateAndResident);

    List<VoFindAll> findByBuildingUnitId(Integer id);

    Map<String, Object> importBuildingUnitEstate(MultipartFile file);
}
