package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchNewsManagement;
import com.api.model.operationManagement.SysNewsManagement;
import com.api.vo.operationManagement.VoFBINewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;

import java.util.List;

public interface SysNewsManagementDao {
    /**
     * 查询所有的资讯信息 （包含条件搜索）
     * @param searchNewsManagement 搜索条件
     * @return 资讯信息
     */
    List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement);

    /**
     * 添加资讯信息
     * @param sysNewsManagement 资讯信息
     * @return 影响行数
     */
    int insert(SysNewsManagement sysNewsManagement);

    /**
     * 根据资讯主键id 查询  资讯信息
     * @param newsId 资讯主键id
     * @return 资讯信息
     */
    VoFBINewsManagement findById(Integer newsId);

    /**
     * 修改资讯信息
     * @param sysNewsManagement 资讯信息
     * @return 影响行数
     */
    int update(SysNewsManagement sysNewsManagement);

    /**
     * 删除资讯信息
     * @param id 资讯信息主键Id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 查询数据库是否存在该资讯标题
     * @param title 资讯标题
     * @return 存在数量
     */
    int countByTitle(String title);

}
