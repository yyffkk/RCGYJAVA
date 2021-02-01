package com.api.butlerApp.service.login;

import com.api.model.butlerApp.ButlerLoginToken;

import java.util.Map;

public interface ButlerAppSignOutService {
    Map<String, Object> signOut(Integer id);
}
