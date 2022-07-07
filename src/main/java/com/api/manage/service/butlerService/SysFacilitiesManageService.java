package com.api.manage.service.butlerService;

import com.api.model.butlerService.FacilitiesManage;
import com.api.model.butlerService.SearchFacilitiesManage;
import com.api.vo.butlerService.VoFacilitiesManage;

import java.util.List;
import java.util.Map;

public interface SysFacilitiesManageService {
    List<VoFacilitiesManage> list(SearchFacilitiesManage searchFacilitiesManage);

    Map<String, Object> insert(FacilitiesManage facilitiesManage);

    Map<String, Object> update(FacilitiesManage facilitiesManage);

    Map<String, Object> findDetailById(Integer id);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> isEnable(Integer id);
}
