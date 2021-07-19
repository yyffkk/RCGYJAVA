package com.api.butlerApp.service.jurisdiction;

import com.api.model.app.AppHousekeepingService;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;
import java.util.Map;

public interface ButlerHousekeepingServiceService {
    List<AppHousekeepingServiceVo> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch, int type);

    Map<String, Object> findPickUpSinglePersonnel(int organizationId);

    Map<String, Object> sendSingle(AppHousekeepingService appHousekeepingService, String roleId);

    int findJurisdictionByUserId(String roleIds);

}
