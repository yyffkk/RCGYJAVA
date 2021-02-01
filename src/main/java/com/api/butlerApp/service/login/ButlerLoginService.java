package com.api.butlerApp.service.login;

import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerLoginToken;
import com.api.model.butlerApp.ButlerUserCode;

import java.util.Map;

public interface ButlerLoginService {
    Map<String, Object> sendMMSLogin(ButlerUserCode butlerUserCode);

    Map<String, Object> loginSMSUser(ButlerUserCode butlerUserCode);

    ButlerLoginToken findULTByTokenId(Long tokenId);

    SysUser findSysUserById(Integer sysUserId);

    int updateBLTById(ButlerLoginToken butlerLoginToken);
}
