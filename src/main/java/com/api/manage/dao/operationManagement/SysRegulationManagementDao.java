package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchRegulationManagement;
import com.api.model.operationManagement.SysRegulationManagement;
import com.api.vo.operationManagement.VoFBIRegulationManagement;
import com.api.vo.operationManagement.VoRegulationManagement;

import java.util.List;

public interface SysRegulationManagementDao {
    /**
     * 查询所有的规程管理信息（包含条件搜索）
     * @param searchRegulationManagement 规程管理搜索条件
     * @return 规程管理信息
     */
    List<VoRegulationManagement> list(SearchRegulationManagement searchRegulationManagement);

    /**
     * 添加规程信息
     * @param sysRegulationManagement 规程管理model信息
     * @return 影响行数
     */
    int insert(SysRegulationManagement sysRegulationManagement);

    /**
     * 根据规程主键id查询规程信息
     * @param id 规程主键id
     * @return 规程信息
     */
    VoFBIRegulationManagement findById(Integer id);

    /**
     * 修改规程信息
     * @param sysRegulationManagement 规程管理model信息
     * @return 影响行数
     */
    int update(SysRegulationManagement sysRegulationManagement);

    /**
     * 根据规程信息主键Id 删除规程信息
     * @param id 规程信息主键Id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 发布
     * @param sysRegulationManagement 规程管理model信息
     * @return 影响行数
     */
    int release(SysRegulationManagement sysRegulationManagement);
}
