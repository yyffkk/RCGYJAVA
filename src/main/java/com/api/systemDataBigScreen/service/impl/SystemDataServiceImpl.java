package com.api.systemDataBigScreen.service.impl;

import com.api.systemDataBigScreen.dao.SystemDataDao;
import com.api.systemDataBigScreen.service.SystemDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SystemDataServiceImpl implements SystemDataService {
    @Resource
    SystemDataDao systemDataDao;
}
