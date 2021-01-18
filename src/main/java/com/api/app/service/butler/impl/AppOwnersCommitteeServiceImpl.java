package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppOwnersCommitteeDao;
import com.api.app.service.butler.AppOwnersCommitteeService;
import com.api.vo.butlerService.VoOwnersCommittee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppOwnersCommitteeServiceImpl implements AppOwnersCommitteeService {
    @Resource
    AppOwnersCommitteeDao appOwnersCommitteeDao;

    @Override
    public List<VoOwnersCommittee> findAll() {
        return appOwnersCommitteeDao.findAll();
    }
}
