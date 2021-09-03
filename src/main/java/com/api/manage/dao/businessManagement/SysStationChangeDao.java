package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchStationChange;
import com.api.model.businessManagement.SysStationChange;

import java.util.List;

public interface SysStationChangeDao {
    /**
     * 查询所有的岗位变动信息
     * @param searchStationChange 岗位变动 搜素条件
     * @return 岗位变动信息
     */
    List<SysStationChange> list(SearchStationChange searchStationChange);

    /**
     * 添加岗位变动信息
     * @param sysStationChange 岗位变动model
     * @return 影响行数
     */
    int insert(SysStationChange sysStationChange);

    /**
     * 根据岗位变动主键id删除岗位变动信息
     * @param id 岗位变动主键id
     * @return 影响行数
     */
    int delete(int id);
}
