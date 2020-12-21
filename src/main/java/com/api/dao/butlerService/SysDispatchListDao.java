package com.api.dao.butlerService;

import com.api.model.butlerService.CancelWorkOrder;
import com.api.model.butlerService.RevisitWorkOrder;
import com.api.model.butlerService.SearchDispatchList;
import com.api.vo.butlerService.VoDispatchList;

import java.util.List;

public interface SysDispatchListDao {
    /**
     * 查询所有的派工单信息 （包含条件搜素）
     * @param searchDispatchList 搜索条件
     * @return map
     */
    List<VoDispatchList> list(SearchDispatchList searchDispatchList);

    /**
     * 假删除工单
     * @param id 工单主键id
     * @return 影响行数
     */
    int falseDelete(Integer id);

    /**
     * 作废工单
     * @param cancelWorkOrder 作废信息
     * @return 影响行数
     */
    int cancel(CancelWorkOrder cancelWorkOrder);

    /**
     * 回访
     * @param revisitWorkOrder 回访信息
     * @return 影响行数
     */
    int revisit(RevisitWorkOrder revisitWorkOrder);
}
