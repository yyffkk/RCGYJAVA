package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;

import java.util.List;

public interface ButlerFacilitiesCheckDao {
    /**
     * 查询所有的设施设备检查信息
     * @param butlerFacilitiesCheckSearch 管家app 设施设备检查搜索条件
     * @return 设施设备检查信息
     */
    List<ButlerFacilitiesCheckVo> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch);
}
