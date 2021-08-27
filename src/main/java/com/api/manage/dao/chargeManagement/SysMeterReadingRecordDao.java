package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.SearchMeterReadingRecord;
import com.api.model.chargeManagement.SysMeterReadingData;
import com.api.model.chargeManagement.SysMeterReadingRecord;
import com.api.vo.chargeManagement.VoMeterReadingRecord;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有的抄表记录信息
     * @param searchMeterReadingRecord 抄表记录搜索条件
     * @return 抄表记录信息
     */
    List<VoMeterReadingRecord> list(SearchMeterReadingRecord searchMeterReadingRecord);

    /**
     * 添加备注
     * @param sysMeterReadingRecord 抄表记录管理
     * @return map
     */
    Integer updateRemakes(SysMeterReadingRecord sysMeterReadingRecord);

    /**
     * 更新抄表数据（电量，水量）
     * @param sysMeterReadingData 抄表数据
     * @return 影响行数
     */
    int updateMeterReadingData(SysMeterReadingData sysMeterReadingData);

    /**
     * 根据抄表类型获取抄表数据
     * @param type 抄表类型
     * @return 抄表数据
     */
    SysMeterReadingData findMeterReadingDataByType(int type);
}
