package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.EvaluationDao;
import com.api.manage.service.shoppingCenter.EvaluationService;
import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.vo.shoppingCenter.EvaluationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    EvaluationDao evaluationDao;

    @Override
    public List<EvaluationVo> list(EvaluationSearch evaluationSearch) {
        return evaluationDao.list(evaluationSearch);
    }
}
