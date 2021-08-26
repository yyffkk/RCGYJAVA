package com.api.manage.service.chargeManagement;

import java.util.Map;

public interface SysMeterReadingRecordService {
    Map<String,Object> getElectricQuantity(String authorization);

    Map<String,Object> getWaterQuantity(String authorization);

    Map<String, Object> getKey();

    Boolean insertElectricQuantity(String electricQuantity);

    Boolean insertWaterQuantity(String waterQuantity);
}
