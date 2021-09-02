package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchRPRecords;
import com.api.model.businessManagement.SysRPRecords;

import java.util.List;

public interface SysRPRecordsDao {
    /**
     * 查询所有的奖惩记录
     * @param searchRPRecords 奖惩记录搜索条件
     * @return 奖惩记录集合
     */
    List<SysRPRecords> list(SearchRPRecords searchRPRecords);

    /**
     * 添加奖惩记录
     * @param sysRPRecords 奖惩记录model
     * @return 影响行数
     */
    int insert(SysRPRecords sysRPRecords);

    /**
     * 根据奖惩记录主键id删除奖惩记录
     * @param id 奖惩记录主键id
     * @return 影响行数
     */
    int delete(int id);
}
