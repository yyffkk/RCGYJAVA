package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchPackageCollection;
import com.api.model.operationManagement.SysPackageCollection;
import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;
import java.util.Map;

public interface SysPackageCollectionService {
    List<VoPackageCollection> list(SearchPackageCollection searchPackageCollection);

    Map<String, Object> insert(SysPackageCollection sysPackageCollection);

    Map<String, Object> findById(Integer id);
}
