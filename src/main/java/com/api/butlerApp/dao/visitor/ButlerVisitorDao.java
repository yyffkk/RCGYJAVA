package com.api.butlerApp.dao.visitor;

import com.api.model.butlerApp.ButlerVisitorSearch;
import com.api.vo.butlerApp.ButlerVisitorVo;

import java.util.List;

public interface ButlerVisitorDao {
    /**
     * 管家app显示所有的访客信息 （包含条件搜索）
     * @param butlerVisitorSearch 搜索条件
     * @return 访客信息
     */
    List<ButlerVisitorVo> list(ButlerVisitorSearch butlerVisitorSearch);
}
