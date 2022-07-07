package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.model.butlerApp.ButlerHygieneTaskCheckSituation;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.vo.butlerApp.ButlerHygieneVo;

import java.util.List;
import java.util.Map;

public interface ButlerHygieneService {
    List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch, int type);

    Map<String, Object> complete(SysHygieneTask sysHygieneTask, String name, Integer organizationId, int type);

    int findJurisdictionByUserId(String roleId);

    Map<String, Object> submitCheckInfo(ButlerHygieneTaskCheckSituation hygieneTaskCheckSituation, int type);
}
