package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchElectronicCommerceCategory;
import com.api.model.operationManagement.SysElectronicCommerceCategory;
import com.api.vo.operationManagement.VoElectronicCommerceCategory;

import java.util.List;
import java.util.Map;

public interface SysElectronicCommerceCategoryService {
    List<VoElectronicCommerceCategory> list(SearchElectronicCommerceCategory searchElectronicCommerceCategory);

    Map<String, Object> insert(SysElectronicCommerceCategory sysElectronicCommerceCategory);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysElectronicCommerceCategory sysElectronicCommerceCategory);

    Map<String, Object> delete(int[] ids);
}
