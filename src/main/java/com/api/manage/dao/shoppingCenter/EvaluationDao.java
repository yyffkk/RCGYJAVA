package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.EvaluationSearch;
import com.api.model.shoppingCenter.GoodsReply;
import com.api.vo.shoppingCenter.EvaluationVo;

import java.util.List;

public interface EvaluationDao {
    /**
     * 查询所有的查询所有的商品评价信息
     * @param evaluationSearch 评价搜索条件
     * @return map
     */
    List<EvaluationVo> list(EvaluationSearch evaluationSearch);

    /**
     * 客服回复
     * @param goodsReply 商品预约主键id 和 客服回复内容
     * @return 影响行数
     */
    int reply(GoodsReply goodsReply);

    /**
     * 根据商品预约主键id查询客服回复内容
     * @param goodsAppointmentId 商品预约主键id
     * @return 客服回复内容
     */
    String findReplyById(Integer goodsAppointmentId);
}
