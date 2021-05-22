package com.api.manage.service.businessManagement.impl;

import com.api.manage.dao.businessManagement.SysSalaryDao;
import com.api.manage.service.businessManagement.SysSalaryService;
import com.api.model.businessManagement.SearchSalary;
import com.api.vo.businessManagement.VoSalary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysSalaryServiceImpl implements SysSalaryService {
    @Resource
    SysSalaryDao sysSalaryDao;

    @Override
    public List<VoSalary> list(SearchSalary searchSalary) {
        return sysSalaryDao.list(searchSalary);
    }
}
