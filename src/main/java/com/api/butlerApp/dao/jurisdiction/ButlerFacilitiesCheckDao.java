package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.model.butlerService.FacilitiesExecute;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;

import java.util.List;

public interface ButlerFacilitiesCheckDao {
    /**
     * 查询所有的设施设备检查信息
     * @param butlerFacilitiesCheckSearch 管家app 设施设备检查搜索条件
     * @return 设施设备检查信息
     */
    List<ButlerFacilitiesCheckVo> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch);

    /**
     * 提交报告
     * @param facilitiesExecute 设施/设备检查执行情况
     * @return 影响行数
     */
    int submitCheck(FacilitiesExecute facilitiesExecute);

    /**
     * 根据设施设备检查记录主键id查询设施设备检查记录信息
     * @param id 设施设备检查记录主键id
     * @return 设施设备检查记录信息
     */
    FacilitiesExecute findById(Integer id);
}
