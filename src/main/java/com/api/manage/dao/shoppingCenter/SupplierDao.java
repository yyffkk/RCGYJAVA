package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.Supplier;
import com.api.model.shoppingCenter.SupplierSearch;
import com.api.vo.shoppingCenter.SupplierFBIVo;
import com.api.vo.shoppingCenter.SupplierVo;

import java.util.List;

public interface SupplierDao {
    /**
     * 查询所有的供应商 包含条件查询
     * @param supplierSearch 搜索条件
     * @return 供应商信息
     */
    List<SupplierVo> list(SupplierSearch supplierSearch);

    /**
     * 添加供应商信息
     * @param supplier 供应商信息
     * @return 影响行数
     */
    int insert(Supplier supplier);

    /**
     * 根据供应商主键id 查询 供应商信息 Vo findById 回显
     * @param id 供应商主键id
     * @return 供应商信息 Vo findById 回显
     */
    SupplierFBIVo findById(Integer id);

    /**
     * 修改供应商信息
     * @param supplier 供应商信息
     * @return 影响行数
     */
    int update(Supplier supplier);

    /**
     * 假删除供应商
     * @param id 供应商主键id
     * @return 影响行数
     */
    int delete(int id);
}
