package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysInspectionRouteDao;
import com.api.manage.service.butlerService.SysInspectionRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysInspectionRouteServiceImpl implements SysInspectionRouteService {
    @Resource
    SysInspectionRouteDao sysInspectionRouteDao;
}
