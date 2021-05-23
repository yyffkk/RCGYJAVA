package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerFacilitiesCheckDao;
import com.api.butlerApp.service.jurisdiction.ButlerFacilitiesCheckService;
import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerFacilitiesCheckServiceImpl implements ButlerFacilitiesCheckService {
    @Resource
    ButlerFacilitiesCheckDao butlerFacilitiesCheckDao;

    @Override
    public List<ButlerFacilitiesCheckVo> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch) {
        return butlerFacilitiesCheckDao.list(butlerFacilitiesCheckSearch);
    }
}
