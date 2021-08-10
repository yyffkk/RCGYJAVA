package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysRepairEngineeringDao;
import com.api.manage.service.butlerService.SysRepairEngineeringService;
import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineeringDetail;
import com.api.vo.butlerService.VoRepairEngineeringFBI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRepairEngineeringServiceImpl implements SysRepairEngineeringService {
    private static Map<String,Object> map = null;
    @Resource
    SysRepairEngineeringDao sysRepairEngineeringDao;

    @Override
    public List<VoRepairEngineering> list(SearchRepairEngineering searchRepairEngineering) {
        return sysRepairEngineeringDao.list(searchRepairEngineering);
    }

    @Override
    public Map<String, Object> findById(Integer repairEngineeringId) {
        map = new HashMap<>();
        VoRepairEngineeringDetail voRepairEngineeringDetail = new VoRepairEngineeringDetail();

        //根据工程维修主键Id查询工程维修信息
        VoRepairEngineeringFBI voRepairEngineeringFBI = sysRepairEngineeringDao.findById(repairEngineeringId);
        voRepairEngineeringDetail.setVoRepairEngineeringFBI(voRepairEngineeringFBI);



        return map;
    }
}
