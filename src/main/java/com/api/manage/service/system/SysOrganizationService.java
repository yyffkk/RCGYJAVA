package com.api.manage.service.system;

import com.api.model.system.SysOrganization;

/**
 * 组织service接口
 */
public interface SysOrganizationService {

    /**
     * 根据组织ID查找组织信息
     * @return SysOrganization
     */
    SysOrganization findById(SysOrganization sysOrganization);


}
