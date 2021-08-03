package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairEngineeringVo;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerRepairEngineeringDao {
    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return 报事报修工程维修信息
     */
    List<ButlerRepairEngineeringVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch);

    /**
     * 添加报事报修工程维修
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return 影响行数
     */
    int insert(ButlerRepairEngineering butlerRepairEngineering);
}
