package com.api.dao.butlerService;

import com.api.model.butlerService.ProcessRecord;
import com.api.vo.butlerService.VoProcessRecord;

import java.util.List;

/**
 * 处理进程记录
 */
public interface SysProcessRecordDao {
    /**
     * 添加处理进程记录
     * @param processRecord 处理进程记录信息
     * @return 影响行数
     */
    int insert(ProcessRecord processRecord);

    /**
     * 查询处理进程记录
     * @param id 工单主键id
     * @return 处理进程记录集合
     */
    List<VoProcessRecord> findByDispatchListId(Integer id);
}
