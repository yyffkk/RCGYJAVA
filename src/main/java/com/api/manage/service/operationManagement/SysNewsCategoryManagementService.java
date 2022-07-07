package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchNewsCategoryManagement;
import com.api.model.operationManagement.SysNewsCategoryManagement;
import com.api.vo.operationManagement.VoNewsCategoryManagement;

import java.util.List;
import java.util.Map;

public interface SysNewsCategoryManagementService {
    List<VoNewsCategoryManagement> list(SearchNewsCategoryManagement searchNewsCategoryManagement);

    Map<String, Object> insert(SysNewsCategoryManagement sysNewsCategoryManagement);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysNewsCategoryManagement sysNewsCategoryManagement);

    Map<String, Object> delete(int[] ids);

}
