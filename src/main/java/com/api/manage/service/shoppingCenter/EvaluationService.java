package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.vo.shoppingCenter.EvaluationVo;

import java.util.List;

public interface EvaluationService {
    List<EvaluationVo> list(EvaluationSearch evaluationSearch);
}
