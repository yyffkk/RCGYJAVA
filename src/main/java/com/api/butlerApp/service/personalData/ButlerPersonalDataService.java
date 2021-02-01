package com.api.butlerApp.service.personalData;

import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerUpdateTel;
import com.api.vo.butlerApp.ButlerPersonalDataVo;

import java.util.Map;

public interface ButlerPersonalDataService {
    ButlerPersonalDataVo findById(Integer id);

    Map<String, Object> updateNickName(SysUser sysUser);

    Map<String, Object> updateHeadPortrait(Integer id, String[] fileUrls);

    Map<String, Object> sendTelUpdateCode(ButlerUpdateTel butlerUpdateTel);

    Map<String, Object> updateTel(ButlerUpdateTel butlerUpdateTel, String oldTel);
}
