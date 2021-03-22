package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerInspectionDao;
import com.api.butlerApp.service.jurisdiction.ButlerInspectionService;
import com.api.model.butlerApp.ButlerInspectionSearch;
import com.api.vo.butlerApp.ButlerInspectionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ButlerInspectionServiceImpl implements ButlerInspectionService {
    @Resource
    ButlerInspectionDao butlerInspectionDao;
    private static Map<String,Object> map = null;


    @Override
    public List<ButlerInspectionVo> list(ButlerInspectionSearch butlerInspectionSearch) {
        return butlerInspectionDao.list(butlerInspectionSearch);
    }
}
