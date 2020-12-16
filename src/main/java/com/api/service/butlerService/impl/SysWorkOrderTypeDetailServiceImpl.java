package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysWorkOrderTypeDetailDao;
import com.api.service.butlerService.SysWorkOrderTypeDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysWorkOrderTypeDetailServiceImpl implements SysWorkOrderTypeDetailService {
    @Resource
    SysWorkOrderTypeDetailDao sysWorkOrderTypeDetailDao;
}
