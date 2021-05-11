package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SysOrganization;
import com.api.vo.businessManagement.VoFindByIdOrganization;
import com.api.vo.businessManagement.VoOrganization;

import java.util.List;
import java.util.Map;

/**
 * 组织service接口
 */
public interface SysOrganizationService {

    /**
     * 根据组织ID查找组织信息
     * @return SysOrganization
     */
    VoFindByIdOrganization findById(Integer id);


    /**
     * 查询组织机构管理信息
     * @return 组织架构信息
     */
    List<VoOrganization> list();

    Map<String, Object> insert(SysOrganization sysOrganization);

    Map<String, Object> update(SysOrganization sysOrganization);

    Map<String, Object> delete(Integer id);

    Map<String, Object> stop(Integer id);

    Map<String, Object> recovery(Integer id);

    Map<String, Object> findAllDepartment();

}
