package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.model.butlerService.SysProhibitedKeywords;
import com.api.vo.butlerService.VoProhibitedKeywords;

import java.util.List;
import java.util.Map;

public interface SysProhibitedKeywordsService {
    List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords);

    Map<String, Object> insert(SysProhibitedKeywords sysProhibitedKeywords);

    Map<String, Object> update(SysProhibitedKeywords sysProhibitedKeywords);
}
