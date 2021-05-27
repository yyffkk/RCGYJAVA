package com.api.butlerApp.dao.butler;

import com.api.model.butlerApp.ButlerHousekeeping;
import com.api.vo.butlerApp.ButlerHousekeepingVo;

import java.util.List;

public interface ButlerHousekeepingDao {
    /**
     * 查询所有的家政服务信息
     * @return 家政服务信息
     * @param id
     */
    List<ButlerHousekeepingVo> list(Integer id);

    /**
     * 添加家政服务信息
     * @param butlerHousekeeping 管家app 家政服务model
     * @return 影响行数
     */
    int insert(ButlerHousekeeping butlerHousekeeping);
}
