package com.aku.dao.system;

import com.aku.model.system.SysJurisdiction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限Dao接口
 */
@Component
public interface SysJurisdictionDao {
    List<SysJurisdiction> findByRoleId(Integer roleId);
}
