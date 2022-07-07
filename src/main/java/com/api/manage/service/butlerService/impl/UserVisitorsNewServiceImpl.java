package com.api.manage.service.butlerService.impl;

import com.api.manage.dao.butlerService.UserVisitorsNewDao;
import com.api.manage.service.butlerService.UserVisitorsNewService;
import com.api.model.butlerService.SearchVisitorsNew;
import com.api.vo.butlerService.VoVisitorsNew;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserVisitorsNewServiceImpl implements UserVisitorsNewService {
    @Resource
    UserVisitorsNewDao userVisitorsNewDao;

    @Override
    public List<VoVisitorsNew> list(SearchVisitorsNew searchVisitorsNew) {
        return userVisitorsNewDao.list(searchVisitorsNew);
    }
}
