package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.model.shoppingCenter.GoodsReply;
import com.api.vo.shoppingCenter.EvaluationVo;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    List<EvaluationVo> list(EvaluationSearch evaluationSearch);

    Map<String, Object> reply(GoodsReply goodsReply);
}
