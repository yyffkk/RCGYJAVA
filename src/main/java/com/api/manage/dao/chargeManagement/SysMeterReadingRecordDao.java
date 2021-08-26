package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.SysMeterReadingRecord;

public interface SysMeterReadingRecordDao {
    /**
     * 查询数据库最新的抄表记录数据
     * @return 最新的抄表记录数据
     * @param type
     */
    SysMeterReadingRecord findNewData(Integer type);

    /**
     * 添加当前的抄表记录数据
     * @param sysMeterReadingRecord 抄表记录管理
     * @return 影响行数
     */
    int insertMeterReadingRecord(SysMeterReadingRecord sysMeterReadingRecord);
}
