package com.api.manage.service.butlerService;

import com.api.model.butlerService.SysWorkOrderTimeLimit;
import com.api.vo.butlerService.VoWorkOrderTimeLimit;

import java.util.List;
import java.util.Map;

public interface SysWorkOrderTimeLimitService {
    List<VoWorkOrderTimeLimit> list();

    Map<String, Object> insert(SysWorkOrderTimeLimit sysWorkOrderTimeLimit);

    VoWorkOrderTimeLimit findById(Integer id);

    Map<String, Object> update(SysWorkOrderTimeLimit sysWorkOrderTimeLimit);

    Map<String, Object> delete(int[] ids);
}
