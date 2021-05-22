package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchMaterial;
import com.api.model.operationManagement.SysMaterial;
import com.api.vo.operationManagement.VoMaterial;

import java.util.List;

public interface SysMaterialDao {
    /**
     * 查询所有的物料管理信息
     * @param searchMaterial 物料管理搜索条件
     * @return 物料管理信息
     */
    List<VoMaterial> list(SearchMaterial searchMaterial);

    /**
     * 添加物料信息
     * @param sysMaterial 物料管理model
     * @return 影响行数
     */
    int insert(SysMaterial sysMaterial);

    /**
     * 根据物料主键id删除物料信息
     * @param id 物料主键id
     * @return 物料信息
     */
    int delete(int id);

    /**
     * 修改物料信息
     * @param sysMaterial 物料管理model
     * @return 影响行数
     */
    int update(SysMaterial sysMaterial);
}
