package com.api.butlerApp.service.butler;

import com.api.model.butlerApp.ButlerHousekeeping;
import com.api.vo.butlerApp.ButlerHousekeepingVo;

import java.util.List;
import java.util.Map;

public interface ButlerHousekeepingService {
    List<ButlerHousekeepingVo> list(Integer id);

    Map<String, Object> insert(ButlerHousekeeping butlerHousekeeping, Integer id);
}
