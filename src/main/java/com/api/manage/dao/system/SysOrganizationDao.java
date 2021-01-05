package com.api.manage.dao.system;

import com.api.model.system.SysOrganization;
import org.springframework.stereotype.Component;

/**
 * 组织Dao接口
 */
@Component
public interface SysOrganizationDao {
    /**
     * 根据组织ID查找组织信息
     * @return SysOrganization
     */
    SysOrganization findById(Integer id);
}
