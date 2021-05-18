package com.api.butlerApp.dao.butler;

import com.api.vo.butlerApp.ButlerRegulationManagementVo;

import java.util.List;

public interface ButlerRegulationManagementDao {
    /**
     * 查询所有的规程管理信息
     * @return 规程管理信息
     */
    List<ButlerRegulationManagementVo> list();

}
