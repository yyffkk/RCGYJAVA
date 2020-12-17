package com.api.dao.butlerService;

import com.api.model.butlerService.SearchDispatchList;
import com.api.vo.butlerService.VoDispatchList;

import java.util.List;

public interface SysDispatchListDao {
    /**
     * 查询所有的派工单信息 （包含条件搜素）
     * @param searchDispatchList 搜索条件
     * @return map
     */
    List<VoDispatchList> list(SearchDispatchList searchDispatchList);
}
