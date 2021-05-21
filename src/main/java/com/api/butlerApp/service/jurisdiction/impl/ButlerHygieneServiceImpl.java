package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerHygieneDao;
import com.api.butlerApp.service.jurisdiction.ButlerHygieneService;
import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.vo.butlerApp.ButlerHygieneVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerHygieneServiceImpl implements ButlerHygieneService {
    @Resource
    ButlerHygieneDao butlerHygieneDao;

    @Override
    public List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch) {
        return butlerHygieneDao.list(butlerHygieneSearch);
    }
}
