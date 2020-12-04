package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchProhibitedKeywords;
import com.aku.vo.butlerService.VoProhibitedKeywords;

import java.util.List;

public interface SysProhibitedKeywordsService {
    List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords);
}
