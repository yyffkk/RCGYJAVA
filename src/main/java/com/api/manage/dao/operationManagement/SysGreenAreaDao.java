package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchGreenArea;
import com.api.model.operationManagement.SysGreenArea;
import com.api.vo.operationManagement.VoGreenArea;

import java.util.List;

public interface SysGreenAreaDao {
    /**
     * 查询所有的绿化区域信息（包含条件搜索）
     * @param searchGreenArea 搜索条件
     * @return 绿化区域信息
     */
    List<VoGreenArea> list(SearchGreenArea searchGreenArea);

    /**
     * 添加绿化区域信息
     * @param sysGreenArea 绿化区域model信息
     * @return 影响行数
     */
    int insert(SysGreenArea sysGreenArea);

    /**
     * 根据绿化区域主键id查询绿化区域信息
     * @param id 绿化区域主键id
     * @return 绿化区域信息
     */
    VoGreenArea findById(Integer id);

    /**
     * 修改绿化区域
     * @param sysGreenArea 绿化区域model信息
     * @return 影响行数
     */
    int update(SysGreenArea sysGreenArea);

    /**
     * 根据绿化区域主键id 删除绿化区域信息
     * @param id 绿化区域主键id
     * @return 影响行数
     */
    int delete(int id);
}
