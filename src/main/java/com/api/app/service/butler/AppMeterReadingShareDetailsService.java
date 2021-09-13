package com.api.app.service.butler;

import com.api.vo.app.AppMeterShareVo;

import java.util.List;
import java.util.Map;

public interface AppMeterReadingShareDetailsService {
    Map<String,Object> findAllUnPayList(Integer estateId);
}
