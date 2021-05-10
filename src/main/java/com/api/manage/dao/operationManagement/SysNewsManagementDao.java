package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchNewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;

import java.util.List;

public interface SysNewsManagementDao {
    /**
     * 查询所有的资讯信息 （包含条件搜索）
     * @param searchNewsManagement 搜索条件
     * @return 资讯信息
     */
    List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement);
}
