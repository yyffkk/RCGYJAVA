package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchUser;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFindByIdUser;
import com.api.vo.businessManagement.VoUser;

import java.util.List;
import java.util.Map;

public interface SysUserService {
    List<VoUser> list(SearchUser searchUser);

    Map<String, Object> insert(SysUser sysUser);

    VoFindByIdUser findById(Integer id);

    Map<String, Object> update(SysUser sysUser);

    Map<String, Object> falseDelete(Integer id);

    Map<String, Object> disableLogins(Integer id);

    Map<String, Object> allowLogins(Integer id);

    Map<String, Object> stop(Integer id);

    Map<String, Object> recovery(Integer id);

    Map<String, Object> resetPWD(SysUser sysUser);
}
