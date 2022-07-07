package com.api.manage.dao.system;

import com.api.model.system.SysJurisdiction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限Dao接口
 */
@Component
public interface SysJurisdictionDao {
    /**
     * 根据角色ID查找权限信息
     * @param roleId 角色ID
     * @return 权限信息
     */
    List<SysJurisdiction> findByRoleId(Integer roleId);
}
