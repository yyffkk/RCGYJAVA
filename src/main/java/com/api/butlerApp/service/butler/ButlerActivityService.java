package com.api.butlerApp.service.butler;

import com.api.vo.butlerApp.ButlerActivityVo;

import java.util.List;
import java.util.Map;

public interface ButlerActivityService {
    List<ButlerActivityVo> list();

    Map<String, Object> findById(Integer activityId);
}
