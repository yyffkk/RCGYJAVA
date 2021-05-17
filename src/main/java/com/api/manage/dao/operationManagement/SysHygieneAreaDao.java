package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchHygieneArea;
import com.api.model.operationManagement.SysHygieneArea;
import com.api.vo.operationManagement.VoFBIHygieneArea;
import com.api.vo.operationManagement.VoHygieneArea;

import java.util.List;

public interface SysHygieneAreaDao {
    /**
     * 查询所有的卫生区域信息（包含条件搜索）
     * @param searchHygieneArea 搜索条件
     * @return 卫生区域信息
     */
    List<VoHygieneArea> list(SearchHygieneArea searchHygieneArea);

    /**
     * 添加卫生区域信息
     * @param sysHygieneArea 卫生区域model信息
     * @return 影响行数
     */
    int insert(SysHygieneArea sysHygieneArea);

    /**
     * 根据卫生区域主键id 查询 卫生区域信息
     * @param id 卫生区域主键id
     * @return 卫生区域信息
     */
    VoFBIHygieneArea findById(Integer id);

    /**
     * 修改卫生区域信息
     * @param sysHygieneArea 卫生区域model信息
     * @return 影响行数
     */
    int update(SysHygieneArea sysHygieneArea);

    /**
     * 删除卫生区域信息
     * @param id 卫生区域主键id
     * @return 影响行数
     */
    int delete(int id);
}
