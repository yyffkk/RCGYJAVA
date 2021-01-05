package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SysWorkOrderTimeLimit;
import com.api.vo.butlerService.VoWorkOrderTimeLimit;

import java.util.List;

public interface SysWorkOrderTimeLimitDao {
    /**
     * 查询所有的工单时限管理信息
     * @return 工单时限管理信息集合
     */
    List<VoWorkOrderTimeLimit> list();

    /**
     * 添加工单时限信息
     * @param sysWorkOrderTimeLimit 工单时限信息
     * @return 影响行数
     */
    int insert(SysWorkOrderTimeLimit sysWorkOrderTimeLimit);

    /**
     * 根据工单时限主键id查询工单时限信息
     * @param id 工单时限主键id
     * @return 工单时限信息
     */
    VoWorkOrderTimeLimit findById(Integer id);

    /**
     * 更新工单时限信息
     * @param sysWorkOrderTimeLimit 新工单时限信息
     * @return 影响行数
     */
    int update(SysWorkOrderTimeLimit sysWorkOrderTimeLimit);

    /**
     * 删除工单时限信息
     * @param id 工单时限主键id
     * @return 影响行数
     */
    int delete(int id);
}
