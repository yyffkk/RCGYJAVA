package com.api.app.service.login;

import com.api.model.app.UserCode;
import com.api.model.app.UserRegister;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.UserLoginTokenVo;

import java.util.Map;

public interface AppLoginService {
    Map<String, Object> sendMMSLogin(UserCode userCode);

    Map<String, Object> loginSMSUser(UserCode userCode);

    Map<String, Object> register(UserRegister userRegister);

    UserLoginTokenVo findULTByTokenId(Long valueOf);

    UserResident findUserResidentById(Integer residentId);

    int updateULTById(UserLoginTokenVo userLoginTokenVo);
}
