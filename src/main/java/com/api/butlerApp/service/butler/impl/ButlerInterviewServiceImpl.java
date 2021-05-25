package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerInterviewDao;
import com.api.butlerApp.service.butler.ButlerInterviewService;
import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.vo.butlerApp.ButlerInterviewVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ButlerInterviewServiceImpl implements ButlerInterviewService {
    @Resource
    ButlerInterviewDao butlerInterviewDao;

    @Override
    public List<ButlerInterviewVo> list(ButlerInterviewSearch butlerInterviewSearch) {
        return butlerInterviewDao.list(butlerInterviewSearch);
    }
}
