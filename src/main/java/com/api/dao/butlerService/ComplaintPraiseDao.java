package com.api.dao.butlerService;

import com.api.model.butlerService.SearchUserAdvice;
import com.api.vo.butlerService.VoUserAdvice;

import java.util.List;

public interface ComplaintPraiseDao {
    /**
     * 查询所有的投诉表扬信息（包含条件搜索）
     * @param searchUserAdvice 搜索条件
     * @return 投诉表扬信息
     */
    List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice);

    /**
     * 查询今日投诉条数
     * @return 今日投诉条数
     */
    Integer countComplaintNew();

    /**
     * 查询今日表扬条数
     * @return 今日表扬条数
     */
    Integer countPraiseNew();

}
