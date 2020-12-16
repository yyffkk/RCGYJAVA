package com.api.dao.butlerService;

import com.api.model.butlerService.SysWorkOrderType;
import com.api.vo.butlerService.VoWorkOrderType;

import java.util.List;
import java.util.Map;

public interface SysWorkOrderTypeDao {
    /**
     * 查询所有工单大类信息
     * @return 工单大类信息集合
     */
    List<VoWorkOrderType> list();

    /**
     * 添加工单大类信息
     * @param sysWorkOrderType 工单大类信息
     * @return 影响行数
     */
    int insert(SysWorkOrderType sysWorkOrderType);

    /**
     * 根据工单大类主键id 查询 工单大类信息
     * @param id 工单大类主键id
     * @return 工单大类信息
     */
    VoWorkOrderType findById(Integer id);

    /**
     * 更新工单大类信息
     * @param sysWorkOrderType 新工单大类信息
     * @return 影响行数
     */
    int update(SysWorkOrderType sysWorkOrderType);

    /**
     * 删除工单大类信息
     * @param id 工单大类主键Id
     * @return 影响行数
     */
    int delete(Integer id);
}
