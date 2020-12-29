package com.api.dao.operationManagement;

public interface SysActivityManagementDao {
    /**
     * 根据主键id查询主办次数
     * @param id 主键id
     * @return 主办次数count
     */
    int countBySponsorId(Integer id);
}
