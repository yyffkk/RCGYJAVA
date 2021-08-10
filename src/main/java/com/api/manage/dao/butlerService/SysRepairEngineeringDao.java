package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineering;

import java.util.List;

public interface SysRepairEngineeringDao {
    /**
     * 查询所有的工程维修信息
     * @param searchRepairEngineering 报事报修工程维修 搜索条件
     * @return 工程维修信息
     */
    List<VoRepairEngineering> list(SearchRepairEngineering searchRepairEngineering);
}
