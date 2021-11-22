package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookGoodsSearch;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;

import java.util.List;

public interface JcookGoodsService {
    /**
     * 查询所有的商品信息
     * @param manageJcookGoodsSearch manage jcook商品搜索条件
     * @return map
     */
    List<ManageJcookGoodsVo> list(ManageJcookGoodsSearch manageJcookGoodsSearch);
}
