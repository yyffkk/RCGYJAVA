package com.api.manage.service.operationManagement.impl;

import com.api.manage.dao.operationManagement.SysNewsManagementDao;
import com.api.manage.service.operationManagement.SysNewsManagementService;
import com.api.model.operationManagement.SearchNewsManagement;
import com.api.vo.operationManagement.VoNewsManagement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysNewsManagementServiceImpl implements SysNewsManagementService {
    @Resource
    SysNewsManagementDao sysNewsManagementDao;

    @Override
    public List<VoNewsManagement> list(SearchNewsManagement searchNewsManagement) {
        return sysNewsManagementDao.list(searchNewsManagement);
    }
}
