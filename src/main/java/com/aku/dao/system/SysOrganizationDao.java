package com.aku.dao.system;

import com.aku.model.system.SysOrganization;
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
