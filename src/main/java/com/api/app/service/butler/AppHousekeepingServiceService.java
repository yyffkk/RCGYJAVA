package com.api.app.service.butler;

import com.api.model.app.AppHousekeepingService;

import java.util.Map;

public interface AppHousekeepingServiceService {
    Map<String, Object> submitHousekeeping(AppHousekeepingService appHousekeepingService);
}
