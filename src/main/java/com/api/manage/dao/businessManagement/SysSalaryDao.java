package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchSalary;
import com.api.model.businessManagement.SysSalary;
import com.api.vo.businessManagement.VoSalary;

import java.util.List;

public interface SysSalaryDao {
    /**
     * 查询所有的薪资管理信息
     * @param searchSalary 薪资管理搜索条件
     * @return 薪资管理信息
     */
    List<VoSalary> list(SearchSalary searchSalary);

    /**
     * 添加薪资信息
     * @param sysSalary 薪资信息model
     * @return 影响行数
     */
    int insert(SysSalary sysSalary);

    /**
     * 根据薪资主键id删除薪资信息
     * @param id 薪资主键id
     * @return 薪资信息
     */
    int delete(int id);

    /**
     * 修改薪资信息
     * @param sysSalary 薪资信息model
     * @return 影响行数
     */
    int update(SysSalary sysSalary);
}
