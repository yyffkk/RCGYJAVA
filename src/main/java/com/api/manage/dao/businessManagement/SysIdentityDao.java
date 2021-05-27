package com.api.manage.dao.businessManagement;

import com.api.model.system.SysIdentity;

import java.util.List;

public interface SysIdentityDao {
    /**
     * 查询所有的身份（职业）信息
     * @return 所有的身份（职业）信息
     */
    List<SysIdentity> listAll();
}
