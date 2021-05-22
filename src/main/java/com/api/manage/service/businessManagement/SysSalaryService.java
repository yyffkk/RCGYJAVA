package com.api.manage.service.businessManagement;

import com.api.model.businessManagement.SearchSalary;
import com.api.vo.businessManagement.VoSalary;

import java.util.List;

public interface SysSalaryService {
    List<VoSalary> list(SearchSalary searchSalary);
}
