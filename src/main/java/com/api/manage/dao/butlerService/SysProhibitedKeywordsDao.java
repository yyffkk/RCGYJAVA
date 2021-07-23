package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchProhibitedKeywords;
import com.api.model.butlerService.SysProhibitedKeywords;
import com.api.vo.butlerService.VoProhibitedKeywords;

import java.util.List;

public interface SysProhibitedKeywordsDao {
    /**
     * 显示所有的违禁关键字信息 （包含条件搜索）
     * @param searchProhibitedKeywords 搜索条件
     * @return 违禁关键字信息集合
     */
    List<VoProhibitedKeywords> list(SearchProhibitedKeywords searchProhibitedKeywords);

    /**
     * 添加违禁关键字信息
     * @param sysProhibitedKeywords 违禁关键字model
     * @return 影响行数
     */
    int insert(SysProhibitedKeywords sysProhibitedKeywords);

    /**
     * 修改违禁关键字信息
     * @param sysProhibitedKeywords 违禁关键字model
     * @return 影响行数
     */
    int update(SysProhibitedKeywords sysProhibitedKeywords);
}
