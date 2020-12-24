package com.api.dao.chargeManagement;

import com.api.vo.chargeManagement.VoHandleCompleteDetail;

/**
 * 处理完成情况
 */
public interface SysHandleCompleteDetailDao {

    /**
     * 传出处理完成情况
     * @param id 工单主键id
     * @return 处理完成情况
     */
    VoHandleCompleteDetail findByDispatchListId(Integer id);
}
