package com.api.app.service.login;

import com.api.model.app.UserCode;
import com.api.model.basicArchives.UserResident;

import java.util.Map;

public interface AppLoginService {
    Map<String, Object> sendMMSLogin(UserCode userCode);

    Map<String, Object> loginSMSUser(UserCode userCode);

    Map<String, Object> register(UserResident userResident);
}
