package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairEngineeringDao;
import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerRepairEngineeringServiceImpl implements ButlerRepairEngineeringService {
    @Resource
    ButlerRepairEngineeringDao butlerRepairEngineeringDao;

    @Override
    public List<ButlerRepairVo> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch) {
        return null;
    }
}
