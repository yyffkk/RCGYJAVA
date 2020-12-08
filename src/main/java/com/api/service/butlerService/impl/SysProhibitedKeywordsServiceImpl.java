package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysProhibitedKeywordsDao;
import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.service.butlerService.SysProhibitedKeywordsService;
import com.api.vo.butlerService.VoProhibitedKeywords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysProhibitedKeywordsServiceImpl implements SysProhibitedKeywordsService {
    @Resource
    SysProhibitedKeywordsDao sysProhibitedKeywordsDao;

    @Override
    public List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords) {
        return sysProhibitedKeywordsDao.list(searchProhibitedKeywords);
    }
}
