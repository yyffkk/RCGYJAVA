package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserAdvice;
import com.aku.vo.butlerService.VoUserAdvice;

import java.util.List;

public interface UserAdviceDao {
    /**
     * 查询所有的咨询建议的条件搜索
     * @param searchUserAdvice 搜索条件
     * @return 咨询建议表 Vo list
     */
    List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice);

    int countDetailByAdviceId(Integer id);
}
