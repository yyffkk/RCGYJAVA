package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerUserDecorationNewDao;
import com.api.butlerApp.service.butler.ButlerUserDecorationNewService;
import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerUserDecorationNewServiceImpl implements ButlerUserDecorationNewService {
    @Resource
    ButlerUserDecorationNewDao butlerUserDecorationNewDao;

    @Override
    public List<ButlerUserDecorationNewVo> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch) {
        return butlerUserDecorationNewDao.list(butlerUserDecorationNewSearch);
    }
}
