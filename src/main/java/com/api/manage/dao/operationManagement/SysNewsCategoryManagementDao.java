package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchNewsCategoryManagement;
import com.api.model.operationManagement.SysNewsCategoryManagement;
import com.api.vo.operationManagement.VoNewsCategoryManagement;

import java.util.List;

public interface SysNewsCategoryManagementDao {
    /**
     * 查询所有的资讯分类
     * @param searchNewsCategoryManagement 资讯分类搜索条件
     * @return 资讯分类信息
     */
    List<VoNewsCategoryManagement> list(SearchNewsCategoryManagement searchNewsCategoryManagement);

    /**
     * 添加资讯分类
     * @param sysNewsCategoryManagement 资讯分类管理信息
     * @return 影响行数
     */
    int insert(SysNewsCategoryManagement sysNewsCategoryManagement);

    /**
     * 根据资讯分类主键id 查询 资讯分类信息
     * @param id 资讯分类主键id
     * @return 资讯分类信息
     */
    VoNewsCategoryManagement findById(Integer id);

    /**
     * 修改资讯分类信息
     * @param sysNewsCategoryManagement 资讯分类信息
     * @return 影响行数
     */
    int update(SysNewsCategoryManagement sysNewsCategoryManagement);

    /**
     * 删除商品分类
     * @param id 商品分类主键id
     * @return 影响行数
     */
    int delete(int id);
}
