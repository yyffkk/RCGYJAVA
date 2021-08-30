package com.api.app.dao.butler;

import com.api.model.chargeManagement.SysMeterReadingShareBillDetails;

public interface AppMeterReadingShareDetailsDao {
    /**
     * 根据公摊账单详情主键id查询公摊账单详情
     * @param shareDetailsId 公摊账单详情主键id
     * @return 公摊账单详情
     */
    SysMeterReadingShareBillDetails findShareDetailsById(Integer shareDetailsId);

    /**
     * 根据主键id修改状态
     * @param shareBillDetails 抄表公摊账单详情
     * @return 影响函数
     */
    int updateStatusById(SysMeterReadingShareBillDetails shareBillDetails);
}
