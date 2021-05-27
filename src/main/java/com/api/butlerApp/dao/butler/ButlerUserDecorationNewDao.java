package com.api.butlerApp.dao.butler;

import com.api.model.butlerApp.ButlerUserDecorationNewSearch;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;

import java.util.List;

public interface ButlerUserDecorationNewDao {
    /**
     * 查询所有的装修管理信息
     * @param butlerUserDecorationNewSearch 管家app 新版装修搜索条件
     * @return map
     */
    List<ButlerUserDecorationNewVo> list(ButlerUserDecorationNewSearch butlerUserDecorationNewSearch);
}
