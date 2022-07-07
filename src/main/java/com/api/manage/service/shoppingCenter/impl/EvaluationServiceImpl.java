package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.EvaluationDao;
import com.api.manage.service.shoppingCenter.EvaluationService;
import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.model.shoppingCenter.GoodsReply;
import com.api.vo.shoppingCenter.EvaluationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    private static Map<String,Object> map = null;
    @Resource
    EvaluationDao evaluationDao;

    @Override
    public List<EvaluationVo> list(EvaluationSearch evaluationSearch) {
        return evaluationDao.list(evaluationSearch);
    }

    @Override
    public Map<String, Object> reply(GoodsReply goodsReply) {
        map = new HashMap<>();
        //根据商品预约主键id查询客服回复内容
        String replyContent = evaluationDao.findReplyById(goodsReply.getGoodsAppointmentId());
        if (replyContent != null){
            map.put("message","已回复");
            map.put("status",false);
            return map;
        }
        goodsReply.setReplyDate(new Date());
        //客服回复
        int update = evaluationDao.reply(goodsReply);
        if (update >0){
            map.put("message","回复成功");
            map.put("status",true);
        }else {
            map.put("message","回复失败");
            map.put("status",false);
        }
        return map;
    }
}
