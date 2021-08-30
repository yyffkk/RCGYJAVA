package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingShareBillDetails;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SysMeterReadingRecordService {
    Map<String,Object> getElectricQuantity(String authorization);

    Map<String,Object> getWaterQuantity(String authorization);

    Map<String, Object> getKey();

    Boolean insertElectricQuantity(BigDecimal electricQuantity);

    Boolean insertWaterQuantity(BigDecimal waterQuantity);

    List<VoMeterReadingRecord> list(SearchMeterReadingRecord searchMeterReadingRecord);

    Map<String, Object> updateRemakes(SysMeterReadingRecord sysMeterReadingRecord);

    Map<String,Object> updateElectricData(String electricQuantity);

    Map<String, Object> updateWaterData(String waterQuantity);

    SysMeterReadingData findMeterReadingDataByType(int type);

    Map<String, Object> createShareBill(SysMeterReadingShareBill sysMeterReadingShareBill);

    List<VoMeterReadingShareBillDetails> findShareBillDetailsListByShareId(SearchShareBillDetails searchShareBillDetails);
}
