package com.api.app.service.personalData;

import com.api.model.basicArchives.UserResident;
import com.api.vo.app.PersonalDataVo;

import java.util.Map;

public interface PersonalDataService {
    PersonalDataVo findById(Integer id);

    Map<String, Object> updateNickName(UserResident userResident);
}
