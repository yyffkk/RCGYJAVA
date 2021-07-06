package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchMaterialInventory;
import com.api.model.operationManagement.SysMaterialInventory;
import com.api.model.operationManagement.SysMaterialInventoryDetail;
import com.api.vo.operationManagement.VoMaterialInventory;

import java.util.List;

public interface SysMaterialInventoryDao {
    /**
     * 查询所有的物料盘点管理信息
     * @param searchMaterialInventory 物资盘点搜索条件
     * @return 的物料盘点管理信息
     */
    List<VoMaterialInventory> list(SearchMaterialInventory searchMaterialInventory);

    /**
     * 根据物料盘点主键id查询物料盘点详情数量
     * @param id 物料盘点主键id
     * @return 物料盘点详情数量
     */
    int countSMIDBySMIId(Integer id);

    /**
     * 添加物料盘点管理信息
     * @param sysMaterialInventory 物资盘点管理
     * @return 影响行数
     */
    int insert(SysMaterialInventory sysMaterialInventory);

    /**
     * 添加物料盘点详情管理信息
     * @param sysMaterialInventoryDetail 物资盘点详情管理
     * @return 影响行数
     */
    int insertDetail(SysMaterialInventoryDetail sysMaterialInventoryDetail);
}
