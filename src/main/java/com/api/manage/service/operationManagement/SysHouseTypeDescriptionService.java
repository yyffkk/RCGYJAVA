package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchHouseTypeDescription;
import com.api.model.operationManagement.SysHouseTypeDescription;
import com.api.vo.operationManagement.SysHouseTypeDescriptionListVo;

import java.util.List;
import java.util.Map;

public interface SysHouseTypeDescriptionService {
    /**
     * 查询所有的户型说明
     * @param searchHouseTypeDescription 户型说明搜索条件
     * @return 所有的户型说明
     */
    List<SysHouseTypeDescriptionListVo> list(SearchHouseTypeDescription searchHouseTypeDescription);

    Map<String, Object> findById(Integer id);

    Map<String, Object> insert(SysHouseTypeDescription sysHouseTypeDescription);

    Map<String, Object> update(SysHouseTypeDescription sysHouseTypeDescription);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> release(Integer id);
}
