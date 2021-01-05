package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.ActivityManagement;
import com.api.model.operationManagement.SearchActivityManagement;
import com.api.vo.operationManagement.VoActivityManagement;
import com.api.vo.operationManagement.VoActivityRegistration;
import com.api.vo.operationManagement.VoFindByIdActivityManagement;
import com.api.vo.resources.VoResourcesImg;

import java.util.List;
import java.util.Map;

public interface SysActivityManagementService {
    List<VoActivityManagement> list(SearchActivityManagement searchActivityManagement);

    List<VoResourcesImg> findImgById(Integer id);

    List<VoActivityRegistration> findRegistrationById(Integer id);

    Map<String, Object> insert(ActivityManagement activityManagement);

    VoFindByIdActivityManagement findById(Integer id);

    Map<String, Object> update(ActivityManagement activityManagement);

    Map<String, Object> falseDelete(int[] ids);
}
