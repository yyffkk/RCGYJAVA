package com.api.app.service.personalData;

import com.api.model.app.PersonalData;
import com.api.model.app.UpdateTel;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.PersonalDataVo;

import java.util.Map;

public interface PersonalDataService {
    PersonalDataVo findById(Integer id);

    Map<String, Object> updateNickName(UserResident userResident);

    Map<String, Object> updateHeadPortrait(Integer id, String[] fileUrls);



    Map<String, Object> sendTelUpdateCode(UpdateTel updateTel);

    Map<String, Object> updateTel(UpdateTel updateTel, String oldTel);

    Map<String, Object> updateSex(PersonalData personalData);

    Map<String, Object> updateBirthday(PersonalData personalData);
}
