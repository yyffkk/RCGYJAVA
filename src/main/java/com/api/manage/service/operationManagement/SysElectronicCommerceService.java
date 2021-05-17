package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchElectronicCommerce;
import com.api.model.operationManagement.SysElectronicCommerce;
import com.api.vo.operationManagement.VoElectronicCommerce;

import java.util.List;
import java.util.Map;

public interface SysElectronicCommerceService {
    List<VoElectronicCommerce> list(SearchElectronicCommerce searchElectronicCommerce);

    Map<String, Object> insert(SysElectronicCommerce sysElectronicCommerce);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysElectronicCommerce sysElectronicCommerce);

    Map<String, Object> delete(int[] ids);
}
