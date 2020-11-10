package com.aku.service.system;

import com.aku.model.system.SysJurisdiction;

import java.util.List;

/**
 * 权限service接口
 */
public interface SysJurisdictionService {
    /**
     * 根据角色ID查找权限信息
     * @param roleId 角色ID
     * @return 权限信息
     */
    List<SysJurisdiction> findByRoleId(Integer roleId);
}
