package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingRecord;

import java.util.List;
import java.util.Map;

public interface SysMeterReadingRecordService {
    Map<String,Object> getElectricQuantity(String authorization);

    Map<String,Object> getWaterQuantity(String authorization);

    Map<String, Object> getKey();

    Boolean insertElectricQuantity(String electricQuantity);

    Boolean insertWaterQuantity(String waterQuantity);

    List<VoMeterReadingRecord> list(SearchMeterReadingRecord searchMeterReadingRecord);
}
