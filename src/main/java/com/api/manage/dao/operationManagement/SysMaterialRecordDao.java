package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchMaterialRecord;
import com.api.model.operationManagement.SysMaterialRecord;
import com.api.vo.operationManagement.VoFBIMaterialRecord;
import com.api.vo.operationManagement.VoMaterialRecord;

import java.util.List;

public interface SysMaterialRecordDao {
    /**
     * 查询所有的物料出入库记录信息
     * @param searchMaterialRecord 物料出入库记录搜索条件
     * @return 物料出入库记录信息
     */
    List<VoMaterialRecord> list(SearchMaterialRecord searchMaterialRecord);


    /**
     * 出库
     * @param sysMaterialRecord 物料出入库记录model信息
     * @return 影响行数
     */
    int delivery(SysMaterialRecord sysMaterialRecord);

    /**
     * 入库
     * @param sysMaterialRecord 物料出入库记录model信息
     * @return 影响行数
     */
    int warehousing(SysMaterialRecord sysMaterialRecord);
    /**
     * 添加出入库数据
     * @param sysMaterialRecord 物料出入库记录model信息
     * @return 影响行数
     */
    int insert(SysMaterialRecord sysMaterialRecord);

    /**
     * 根据物资出库入主键id查询物资出入库记录详情
     * @param id 物资出库入主键id
     * @return 物资出入库记录详情
     */
    VoFBIMaterialRecord findById(Integer id);

    /**
     * 批量删除物料出入库记录信息
     * @param id 物料出入库记录信息主键id
     * @return 影响行数
     */
    int delete(int id);
}
