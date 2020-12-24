package com.api.service.chargeManagement.impl;

import com.api.dao.chargeManagement.SysDepositManagementDao;
import com.api.model.chargeManagement.SearchDepositManagement;
import com.api.service.chargeManagement.SysDepositManagementService;
import com.api.vo.chargeManagement.VoDepositManagement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDepositManagementServiceImpl implements SysDepositManagementService {
    @Resource
    SysDepositManagementDao sysDepositManagementDao;

    @Override
    public List<VoDepositManagement> list(SearchDepositManagement searchDepositManagement) {
        return sysDepositManagementDao.list(searchDepositManagement);
    }
}
