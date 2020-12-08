package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysVoteDao;
import com.api.service.butlerService.SysVoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysVoteServiceImpl implements SysVoteService {
    @Resource
    SysVoteDao sysVoteDao;

}
