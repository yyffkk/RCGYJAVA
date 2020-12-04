package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.SysProhibitedKeywordsDao;
import com.aku.model.butlerService.SearchProhibitedKeywords;
import com.aku.service.butlerService.SysProhibitedKeywordsService;
import com.aku.vo.butlerService.VoProhibitedKeywords;
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
