package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchMaterialInventory;
import com.api.model.operationManagement.SysMaterialInventory;
import com.api.vo.operationManagement.VoMaterialInventory;

import java.util.List;
import java.util.Map;

public interface SysMaterialInventoryService {
    /**
     * 查询所有的物料盘点管理信息
     * @param searchMaterialInventory 物资盘点搜索条件
     * @return 的物料盘点管理信息
     */
    List<VoMaterialInventory> list(SearchMaterialInventory searchMaterialInventory);

    /**
     * 添加物料盘点管理信息
     * @param sysMaterialInventory 物资盘点管理
     * @return map
     */
    Map<String, Object> insert(SysMaterialInventory sysMaterialInventory);

    /**
     * 根据物料盘点主键id查询物料盘点信息详情
     * @param id 物料盘点主键id
     * @return map
     */
    Map<String, Object> findById(Integer id);
}
