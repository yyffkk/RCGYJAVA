package com.api.dao.butlerService;

import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.vo.butlerService.VoProhibitedKeywords;

import java.util.List;

public interface SysProhibitedKeywordsDao {
    /**
     * 显示所有的违禁关键字信息 （包含条件搜索）
     * @param searchProhibitedKeywords 搜索条件
     * @return 违禁关键字信息集合
     */
    List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords);
}
