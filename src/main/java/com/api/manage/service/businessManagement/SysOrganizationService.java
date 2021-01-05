package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchOrganization;
import com.api.model.businessManagement.SysOrganization;
import com.api.vo.businessManagement.VoOrganization;

/**
 * 组织service接口
 */
public interface SysOrganizationService {

    /**
     * 根据组织ID查找组织信息
     * @return SysOrganization
     */
    SysOrganization findById(SysOrganization sysOrganization);


    /**
     * 查询组织机构管理信息
     * @param searchOrganization 搜索条件
     * @return 组织架构信息
     */
    VoOrganization list(SearchOrganization searchOrganization);
}
