package com.api.app.dao.butler;

import com.api.model.app.UserIdAndRepairId;
import com.api.vo.app.AppDispatchListVo;
import com.api.vo.app.AppProcessRecordVo;
import com.api.vo.app.AppReportRepairVo;

import java.util.List;

public interface AppReportRepairDao {
    /**
     * app查询当前用户的报事报修信息
     * @param id 用户主键id
     * @return app报事报修Vo list
     */
    List<AppReportRepairVo> list(Integer id);

    /**
     * 根据用户id和报事报修主键id查询app报事报修Vo
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return app报事报修Vo
     */
    AppReportRepairVo findRepairByIds(UserIdAndRepairId userIdAndRepairId);

    /**
     * 根据用户id和报事报修主键id查询app维修信息
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return app维修信息
     */
    AppDispatchListVo findDispatchListByIds(UserIdAndRepairId userIdAndRepairId);

    /**
     * 根据用户id和报事报修主键id查询app进程处理
     * @param userIdAndRepairId 用户id和报事报修主键id
     * @return app进程处理集合
     */
    List<AppProcessRecordVo>  findProcessRecordByIds(UserIdAndRepairId userIdAndRepairId);
}
