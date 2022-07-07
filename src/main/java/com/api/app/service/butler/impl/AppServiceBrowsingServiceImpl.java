package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppServiceBrowsingDao;
import com.api.app.service.butler.AppServiceBrowsingService;
import com.api.vo.app.AppServiceBrowsingVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppServiceBrowsingServiceImpl implements AppServiceBrowsingService {
    @Resource
    AppServiceBrowsingDao appServiceBrowsingDao;

    @Override
    public List<AppServiceBrowsingVo> list() {
        return appServiceBrowsingDao.list();
    }
}
