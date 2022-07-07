package com.api.manage.service.system;

import java.util.Map;

public interface SysSettingsService {
    Map<String, Object> list();

    Map<String, Object> isEnable(Integer id);
}
