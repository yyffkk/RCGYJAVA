package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchElectronicCommerceCategory;
import com.api.model.operationManagement.SysElectronicCommerceCategory;
import com.api.vo.operationManagement.VoElectronicCommerceCategory;
import com.api.vo.operationManagement.VoNewsCategoryManagement;

import java.util.List;

public interface SysElectronicCommerceCategoryDao {
    /**
     * 查询所有的电子商务分类
     * @param searchElectronicCommerceCategory 电子商务分类搜索条件
     * @return 电子商务分类
     */
    List<VoElectronicCommerceCategory> list(SearchElectronicCommerceCategory searchElectronicCommerceCategory);

    /**
     * 添加电子商务分类
     * @param sysElectronicCommerceCategory 电子商务分类model信息
     * @return 影响行数
     */
    int insert(SysElectronicCommerceCategory sysElectronicCommerceCategory);

    /**
     * 根据电子商务分类主键id 查询 电子商务分类信息
     * @param id 电子商务分类主键id
     * @return 电子商务分类信息
     */
    VoElectronicCommerceCategory findById(Integer id);

    /**
     * 修改电子商务分类信息
     * @param sysElectronicCommerceCategory 电子商务分类信息
     * @return 影响行数
     */
    int update(SysElectronicCommerceCategory sysElectronicCommerceCategory);

    /**
     * 删除电子商务分类
     * @param id 电子商务分类主键id
     * @return 影响行数
     */
    int delete(int id);
}
