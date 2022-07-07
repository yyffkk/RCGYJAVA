package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchElectronicCommerce;
import com.api.model.operationManagement.SysElectronicCommerce;
import com.api.vo.operationManagement.VoElectronicCommerce;
import com.api.vo.operationManagement.VoFBIElectronicCommerce;

import java.util.List;

public interface SysElectronicCommerceDao {
    /**
     * 查询所有的电子商务信息 （包含条件搜索）
     * @param searchElectronicCommerce 电子商务搜索条件
     * @return 电子商务信息
     */
    List<VoElectronicCommerce> list(SearchElectronicCommerce searchElectronicCommerce);

    /**
     * 添加电子商务信息
     * @param sysElectronicCommerce 电子商务管理model信息
     * @return 影响行数
     */
    int insert(SysElectronicCommerce sysElectronicCommerce);

    /**
     * 根据电子商务主键id 查询 电子商务信息
     * @param id 电子商务主键id
     * @return 电子商务信息
     */
    VoFBIElectronicCommerce findById(Integer id);

    /**
     * 修改电子商务信息
     * @param sysElectronicCommerce 电子商务信息
     * @return 影响行数
     */
    int update(SysElectronicCommerce sysElectronicCommerce);

    /**
     * 根据 电子商务信息主键id 删除电子商务信息
     * @param id 电子商务信息主键id
     * @return 影响行数
     */
    int delete(int id);
}
