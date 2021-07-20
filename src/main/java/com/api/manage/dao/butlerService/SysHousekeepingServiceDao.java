package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchHousekeepingService;
import com.api.vo.app.AppHousekeepingServiceVo;

import java.util.List;

public interface SysHousekeepingServiceDao {
    /**
     * 查询所有的家政服务信息（包含条件搜索）
     * @param searchHousekeepingService 家政服务搜索条件
     * @return 家政服务信息
     */
    List<AppHousekeepingServiceVo> list(SearchHousekeepingService searchHousekeepingService);
}
