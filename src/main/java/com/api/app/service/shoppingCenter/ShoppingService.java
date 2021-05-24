package com.api.app.service.shoppingCenter;

import com.api.model.app.AppGoodsAppointment;
import com.api.model.shoppingCenter.Evaluation;
import com.api.vo.app.AppGoodsVo;
import com.api.vo.app.AppMyOrderVo;

import java.util.List;
import java.util.Map;

public interface ShoppingService {
    Map<String, Object> list(Integer parentId);

    Map<String, Object> findTopGoods();

    List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId);

    Map<String, Object> findDetailByGoodsId(Integer goodsId, Integer id);

    Map<String, Object> findTopGoodsBySupplierId(Integer supplierId);

    Map<String, Object> goodsAppointment(AppGoodsAppointment appGoodsAppointment, Integer type, Integer id);

    List<AppGoodsVo> goodsSearch(String searchName);

    List<AppMyOrderVo> myOrder(Integer id, Integer orderStart);

    Map<String, Object> cancel(Integer id, Integer goodsAppointmentId);

    Map<String, Object> applicationRefund(Integer id, Integer goodsAppointmentId, String backReason);

    Map<String, Object> confirmReceipt(Integer id, Integer goodsAppointmentId);

    Map<String, Object> evaluation(Evaluation evaluation);
}
