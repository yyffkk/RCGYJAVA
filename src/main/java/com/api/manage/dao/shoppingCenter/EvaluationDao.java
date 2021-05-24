package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.vo.shoppingCenter.EvaluationVo;

import java.util.List;

public interface EvaluationDao {
    /**
     * 查询所有的查询所有的商品评价信息
     * @param evaluationSearch 评价搜索条件
     * @return map
     */
    List<EvaluationVo> list(EvaluationSearch evaluationSearch);
}
