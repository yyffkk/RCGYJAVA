package com.api.app.service.butler.impl;

import com.api.app.dao.butler.DecorationApplicationDao;
import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.SearchAppDecoration;
import com.api.vo.app.AppDecorationAdditionalCostVo;
import com.api.vo.app.AppDecorationCostVo;
import com.api.vo.app.AppDecorationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DecorationApplicationServiceImpl implements DecorationApplicationService {
    @Resource
    DecorationApplicationDao decorationApplicationDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> list(SearchAppDecoration searchAppDecoration) {
        map = new HashMap<>();

        List<AppDecorationVo> decorationVoList = decorationApplicationDao.list(searchAppDecoration);
        map.put("decorationVoList",decorationVoList);
        return map;
    }

    @Override
    public Map<String, Object> decorationCostDetail() {
        map = new HashMap<>();
        //查询装修押金,费用类型为：3.装修押金
        AppDecorationCostVo decorationCostVo = decorationApplicationDao.findDecorationDeposit();
        if (decorationCostVo != null){
            //根据 装修押金费用主键id 查询装修附加费用
            List<AppDecorationAdditionalCostVo> additionalCostVos = decorationApplicationDao.findDecorationAdditionalCost(decorationCostVo.getId());
            decorationCostVo.setAdditionalCostVos(additionalCostVos);
            //查询装修须知doc路径
            String url = decorationApplicationDao.findDecorationDocUrl();
            decorationCostVo.setDocUrl(url);
        }
        map.put("decorationCostVo",decorationCostVo);
        return map;
    }
}
