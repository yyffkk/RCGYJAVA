package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchMaterialInventory;
import com.api.vo.operationManagement.VoMaterialInventory;

import java.util.List;

public interface SysMaterialInventoryDao {
    /**
     * 查询所有的物料盘点管理信息
     * @param searchMaterialInventory 物资盘点搜索条件
     * @return 的物料盘点管理信息
     */
    List<VoMaterialInventory> list(SearchMaterialInventory searchMaterialInventory);

}
