package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysGambitDao;
import com.api.service.butlerService.SysGambitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysGambitServiceImpl implements SysGambitService {
    @Resource
    SysGambitDao sysGambitDao;
}
