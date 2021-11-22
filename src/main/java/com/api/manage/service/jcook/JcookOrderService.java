package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookOrderSearch;
import com.api.vo.jcook.manageOrder.ManageJcookOrderVo;

import java.util.List;

public interface JcookOrderService {
    /**
     * 查询所有的商品订单信息
     * @param manageJcookOrderSearch manage jcook商品订单搜索条件
     * @return 商品订单信息
     */
    List<ManageJcookOrderVo> list(ManageJcookOrderSearch manageJcookOrderSearch);
}
