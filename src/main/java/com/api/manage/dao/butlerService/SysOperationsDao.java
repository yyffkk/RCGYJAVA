package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchOperations;
import com.api.model.butlerService.SysOperations;
import com.api.vo.butlerService.VoOperations;

import java.util.List;

public interface SysOperationsDao {
    /**
     * 查询所有的运维管理（包含条件搜索）
     * @param searchOperations 运维管理 搜索条件
     * @return 运维管理
     */
    List<VoOperations> list(SearchOperations searchOperations);

    /**
     * 添加运维管理信息
     * @param sysOperations 运维管理model
     * @return 影响行数
     */
    int insert(SysOperations sysOperations);

    /**
     * 修改运维管理信息
     * @param sysOperations 运维管理model
     * @return 影响行数
     */
    int update(SysOperations sysOperations);
}
