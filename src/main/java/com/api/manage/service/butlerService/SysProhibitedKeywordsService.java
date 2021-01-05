package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.vo.butlerService.VoProhibitedKeywords;

import java.util.List;

public interface SysProhibitedKeywordsService {
    List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords);
}
