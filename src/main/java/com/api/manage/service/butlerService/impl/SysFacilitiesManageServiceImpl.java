package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.SysFacilitiesManageDao;
import com.api.manage.service.butlerService.SysFacilitiesManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class SysFacilitiesManageServiceImpl implements SysFacilitiesManageService {
    private static Map<String,Object> map = null;

    @Resource
    SysFacilitiesManageDao sysFacilitiesManageDao;

}
