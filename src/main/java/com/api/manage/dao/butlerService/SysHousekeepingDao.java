package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchHousekeeping;
import com.api.vo.butlerService.VoHousekeeping;

import java.util.List;

public interface SysHousekeepingDao {
    /**
     * 查询所有的家政服务信息
     * @param searchHousekeeping 家政服务 搜索条件
     * @return 家政服务信息
     */
    List<VoHousekeeping> list(SearchHousekeeping searchHousekeeping);
}
