package com.aku.service.system;

import com.aku.model.system.SysJurisdiction;

import java.util.List;

/**
 * 权限service接口
 */
public interface SysJurisdictionService {
    List<SysJurisdiction> findByRoleId(Integer roleId);
}
