package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerGreenDao;
import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.vo.butlerApp.ButlerGreenVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerGreenServiceImpl implements ButlerGreenService {
    @Resource
    ButlerGreenDao butlerGreenDao;

    @Override
    public List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch) {
        return butlerGreenDao.list(butlerGreenSearch);
    }
}
