package com.api.manage.service.butlerService;

import com.api.model.butlerService.FacilitiesPlan;
import com.api.model.butlerService.SearchFacilitiesExecute;
import com.api.model.butlerService.SearchFacilitiesPlan;
import com.api.vo.butlerService.VoFacilitiesExecute;
import com.api.vo.butlerService.VoFacilitiesPlan;

import java.util.List;
import java.util.Map;

public interface SysFacilitiesPlanService {
    List<VoFacilitiesPlan> list(SearchFacilitiesPlan searchFacilitiesPlan);

    Map<String, Object> insert(FacilitiesPlan facilitiesPlan);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> stop(int[] ids);

    Map<String, Object> open(int[] ids);

    List<VoFacilitiesExecute> executeList(SearchFacilitiesExecute searchFacilitiesExecute);
}
