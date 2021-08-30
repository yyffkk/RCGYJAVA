package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.*;
import com.api.vo.chargeManagement.VoMeterReadingRecord;

import java.math.BigDecimal;
import java.util.Date;
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

    /**
     * 查询所有的入住的房产ids
     * @param date 当前时间
     * @return 入住的房产ids
     */
    List<Integer> findAllCheckInEstateId(Date date);

    /**
     * 计算出所有入住房产面积的总和
     * @param ids 入住的房产ids
     * @return 所有入住房产面积的总和
     */
    BigDecimal countCheckInEstateAllArea(List<Integer> ids);

    /**
     * 添加抄表公摊账单
     * @param sysMeterReadingShareBill 抄表公摊账单
     * @return 影响行数
     */
    int insertMeterReadingShareBill(SysMeterReadingShareBill sysMeterReadingShareBill);

    /**
     * 根据抄表记录主键Id查询抄表记录
     * @param meterReadingRecordId 抄表记录主键Id
     * @return 抄表记录
     */
    VoMeterReadingRecord findMeterReadingRecordById(Integer meterReadingRecordId);

    /**
     * 修改抄表记录账单状态
     * @param sysMeterReadingRecord 抄表记录管理
     * @return 影响行数
     */
    int updateMeterReadingRecordBillStatus(SysMeterReadingRecord sysMeterReadingRecord);

    /**
     * 添加抄表公摊明细
     * @param shareBillDetails 抄表公摊明细
     * @return 影响行数
     */
    int insertMeterReadingShareBillDetails(SysMeterReadingShareBillDetails shareBillDetails);
}
