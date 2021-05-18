package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerRegulationManagementDao;
import com.api.butlerApp.service.butler.ButlerRegulationManagementService;
import com.api.vo.butlerApp.ButlerRegulationManagementVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerRegulationManagementServiceImpl implements ButlerRegulationManagementService {
    @Resource
    ButlerRegulationManagementDao butlerRegulationManagementDao;

    @Override
    public List<ButlerRegulationManagementVo> list() {
        return butlerRegulationManagementDao.list();
    }
}
