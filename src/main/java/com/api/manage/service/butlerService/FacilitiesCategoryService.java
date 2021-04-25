package com.api.manage.service.butlerService;

import com.api.model.butlerService.FacilitiesCategory;
import com.api.model.butlerService.SearchFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategory;

import java.util.List;
import java.util.Map;

public interface FacilitiesCategoryService {
    List<VoFacilitiesCategory> list(SearchFacilitiesCategory facilitiesCategory);

    Map<String, Object> insert(FacilitiesCategory facilitiesCategory);

    Map<String, Object> findDetailById(Integer id);

    Map<String, Object> update(FacilitiesCategory facilitiesCategory);
}
