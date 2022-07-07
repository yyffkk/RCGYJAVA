package com.api.app.service.butler;

import com.api.vo.app.AppActivityRegistrationVo;
import com.api.vo.app.AppActivityVo;

import java.util.List;
import java.util.Map;

public interface AppActivityService {
    List<AppActivityVo> list(Integer id);

    Map<String, Object> findById(Integer activityId);

    Map<String, Object> signUp(Integer id, Integer activityId);

    List<AppActivityRegistrationVo> participantsList(Integer activityId);
}
