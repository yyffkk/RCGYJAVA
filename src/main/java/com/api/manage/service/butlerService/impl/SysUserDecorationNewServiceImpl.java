package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysUserDecorationNewDao;
import com.api.manage.service.butlerService.SysUserDecorationNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserDecorationNewServiceImpl implements SysUserDecorationNewService {
    @Resource
    SysUserDecorationNewDao sysUserDecorationNewDao;

}
