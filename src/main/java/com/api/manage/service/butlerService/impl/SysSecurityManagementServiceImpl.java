package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysSecurityManagementDao;
import com.api.manage.service.butlerService.SysSecurityManagementService;
import com.api.model.butlerService.SearchSecurityManagement;
import com.api.vo.butlerService.VoSecurityManagement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysSecurityManagementServiceImpl implements SysSecurityManagementService {
    private static Map<String,Object> map = null;
    @Resource
    SysSecurityManagementDao sysSecurityManagementDao;

    @Override
    public List<VoSecurityManagement> list(SearchSecurityManagement searchSecurityManagement) {
        List<VoSecurityManagement> list = sysSecurityManagementDao.list(searchSecurityManagement);

        return list;
    }
}
