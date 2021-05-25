package com.api.butlerApp.dao.butler;

import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.vo.butlerApp.ButlerInterviewVo;

import java.util.List;

public interface ButlerInterviewDao {
    /**
     * 查询所有客户访谈信息
     * @param butlerInterviewSearch 管家app 客户访谈搜索条件
     * @return 客户访谈信息
     */
    List<ButlerInterviewVo> list(ButlerInterviewSearch butlerInterviewSearch);
}
