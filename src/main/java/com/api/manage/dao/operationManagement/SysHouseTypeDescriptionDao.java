package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchHouseTypeDescription;
import com.api.model.operationManagement.SysHouseTypeDescription;
import com.api.vo.operationManagement.SysHouseTypeDescriptionFBIVo;
import com.api.vo.operationManagement.SysHouseTypeDescriptionListVo;

import java.util.List;

public interface SysHouseTypeDescriptionDao {
    /**
     * 查询所有的户型说明
     * @param searchHouseTypeDescription 户型说明搜索条件
     * @return 所有的户型说明
     */
    List<SysHouseTypeDescriptionListVo> list(SearchHouseTypeDescription searchHouseTypeDescription);

    /**
     * 根据户型说明主键id查询户型说明信息
     * @param id 户型说明主键id
     * @return 户型说明信息
     */
    SysHouseTypeDescriptionFBIVo findById(Integer id);

    /**
     * 添加户型说明
     * @param sysHouseTypeDescription 户型说明model
     * @return 影响行数
     */
    int insert(SysHouseTypeDescription sysHouseTypeDescription);

    /**
     * 修改户型说明
     * @param sysHouseTypeDescription 户型说明model
     * @return 影响行数
     */
    int update(SysHouseTypeDescription sysHouseTypeDescription);

    /**
     * 批量删除户型说明
     * @param id 户型说明主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 发布
     * @param sysHouseTypeDescription 户型说明model
     * @return 影响行数
     */
    int release(SysHouseTypeDescription sysHouseTypeDescription);
}
