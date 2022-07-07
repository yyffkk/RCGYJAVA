package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchKeyManagement;
import com.api.model.operationManagement.SysKeyManagement;
import com.api.vo.operationManagement.VoKeyManagement;

import java.util.List;

public interface SysKeyManagementDao {
    /**
     * 查询所有的钥匙信息
     * @param searchKeyManagement 钥匙管理 搜索条件
     * @return 钥匙信息
     */
    List<VoKeyManagement> list(SearchKeyManagement searchKeyManagement);

    /**
     * 添加钥匙信息
     * @param sysKeyManagement 钥匙管理model信息
     * @return 影响行数
     */
    int insert(SysKeyManagement sysKeyManagement);

    /**
     * 根据钥匙主键id查询钥匙信息
     * @param id 钥匙主键id
     * @return 钥匙信息
     */
    VoKeyManagement findById(Integer id);

    /**
     * 修改钥匙信息
     * @param sysKeyManagement 钥匙信息
     * @return 影响行数
     */
    int update(SysKeyManagement sysKeyManagement);

    /**
     * 根据钥匙主键ID删除钥匙信息
     * @param id 钥匙主键ID
     * @return 影响行数
     */
    int delete(int id);
}
