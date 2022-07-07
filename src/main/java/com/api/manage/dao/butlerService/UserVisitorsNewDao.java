package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchVisitorsNew;
import com.api.vo.butlerService.VoVisitorsNew;

import java.util.List;

public interface UserVisitorsNewDao {
    /**
     * 查询所有的新版访客信息
     * @param searchVisitorsNew 新版访客信息搜索条件
     * @return 新版访客信息
     */
    List<VoVisitorsNew> list(SearchVisitorsNew searchVisitorsNew);
}
