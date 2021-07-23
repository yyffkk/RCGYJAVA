package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchOperations;
import com.api.model.butlerService.SysOperations;
import com.api.vo.butlerService.VoOperations;

import java.util.List;
import java.util.Map;

public interface SysOperationsService {
    List<VoOperations> list(SearchOperations searchOperations);

    Map<String, Object> insert(SysOperations sysOperations);
}
