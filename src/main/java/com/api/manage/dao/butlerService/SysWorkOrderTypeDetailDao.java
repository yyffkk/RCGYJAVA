package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SysWorkOrderTypeDetail;
import com.api.vo.butlerService.VoWorkOrderTypeDetail;

import java.util.List;

public interface SysWorkOrderTypeDetailDao {
    /**
     * 根据工单大类主键id查询工单类型明细信息
     * @param id 工单大类主键id
     * @return 工单类型明细信息集合
     */
    List<VoWorkOrderTypeDetail> list(Integer id);

    /**
     * 添加工单类型明细信息
     * @param sysWorkOrderTypeDetail 工单类型明细信息
     * @return 影响行数
     */
    int insert(SysWorkOrderTypeDetail sysWorkOrderTypeDetail);

    /**
     * 根据工单类型明细主键id查询工单类型明细信息
     * @param id 工单类型明细主键id
     * @return 工单类型明细信息
     */
    VoWorkOrderTypeDetail findById(Integer id);

    /**
     * 更新工单类型明细信息
     * @param sysWorkOrderTypeDetail 新工单类型明细信息
     * @return 影响行数
     */
    int update(SysWorkOrderTypeDetail sysWorkOrderTypeDetail);

    /**
     * 删除工单类型明细
     * @param id 工单类型明细主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 先根据工单大类主键id删除工单类型明细信息
     * @param id 工单大类主键id
     * @return 影响行数
     */
    int deleteByWorkOrderTypeId(Integer id);
}
