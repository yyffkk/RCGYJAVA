package com.api.manage.service.businessManagement;

import com.api.model.system.SysIdentity;

import java.util.Map;

public interface SysIdentityService {
    Map<String, Object> listAll();

    Map<String, Object> insert(SysIdentity sysIdentity);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(SysIdentity sysIdentity);

    Map<String, Object> delete(int[] ids);
}
