package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchSalary;
import com.api.model.businessManagement.SysSalary;
import com.api.vo.businessManagement.VoSalary;

import java.util.List;
import java.util.Map;

public interface SysSalaryService {
    List<VoSalary> list(SearchSalary searchSalary);

    Map<String, Object> insert(SysSalary sysSalary);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> update(SysSalary sysSalary);
}
