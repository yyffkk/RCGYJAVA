package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.Interview;
import com.api.model.operationManagement.SearchInterview;
import com.api.vo.operationManagement.VoInterview;

import java.util.List;

public interface SysInterviewDao {
    /**
     * 查询所有的访谈信息
     * @param searchInterview 客户访谈搜索条件
     * @return 访谈信息
     */
    List<VoInterview> list(SearchInterview searchInterview);

    /**
     * 添加访谈信息
     * @param interview 客户访谈model
     * @return 影响行数
     */
    int insert(Interview interview);

    /**
     * 根据访谈信息主键id删除访谈信息
     * @param id 访谈信息主键id
     * @return 影响行数
     */
    int delete(int id);
}
