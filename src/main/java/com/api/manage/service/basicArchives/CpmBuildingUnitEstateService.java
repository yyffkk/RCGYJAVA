package com.api.manage.service.basicArchives;

import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.basicArchives.EstateAndResidentList;
import com.api.model.basicArchives.SearchCpmBuildingUnitEstate;
import com.api.model.basicArchives.UserResident;
import com.api.vo.basicArchives.VoCpmBuildingUnitEstate;
import com.api.vo.basicArchives.VoFindAll;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CpmBuildingUnitEstateService {
    List<VoCpmBuildingUnitEstate> list(SearchCpmBuildingUnitEstate searchCpmBuildingUnitEstate);

    Map<String, Object> insert(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    Map<String, Object> insert(List<UserResident> userResidentList, CpmBuildingUnitEstate cpmBuildingUnitEstate);

    CpmBuildingUnitEstate findById(Integer id);

    Map<String, Object> delete(int[] ids);

    List<VoFindAll> findAll();

    Map<String, Object> update(EstateAndResidentList estateAndResident);

    List<VoFindAll> findByBuildingUnitId(Integer id);

    Map<String, Object> importBuildingUnitEstate(MultipartFile file);

    List<VoFindAll> findByBuildingId(Integer buildingId);

    List<VoFindAll> findUnitByBuildingId(Integer buildingId);

    List<VoFindAll> findEstateIdByUnitId(Integer unitId);
}
