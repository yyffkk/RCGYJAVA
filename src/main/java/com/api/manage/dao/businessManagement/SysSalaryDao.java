package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchSalary;
import com.api.vo.businessManagement.VoSalary;

import java.util.List;

public interface SysSalaryDao {
    /**
     * 查询所有的薪资管理信息
     * @param searchSalary 薪资管理搜索条件
     * @return 薪资管理信息
     */
    List<VoSalary> list(SearchSalary searchSalary);
}
