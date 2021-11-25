package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookGoodsSearch;
import com.api.model.jcook.manageDto.ManageJcookUpdatePriceDTO;
import com.api.vo.jcook.manageGoods.ManageJcookGoodsVo;

import java.util.List;
import java.util.Map;

public interface JcookGoodsService {
    /**
     * 查询所有的商品信息
     * @param manageJcookGoodsSearch manage jcook商品搜索条件
     * @return map
     */
    List<ManageJcookGoodsVo> list(ManageJcookGoodsSearch manageJcookGoodsSearch);

    /**
     * 一键上架
     * @param ids 商品主键id
     * @return map
     */
    Map<String, Object> onShelf(int[] ids);

    /**
     * 一键下架
     * @param ids 商品主键id
     * @return map
     */
    Map<String, Object> offShelf(int[] ids);

    /**
     * 根据商品主键id查询商品详情
     * @param jcookGoodsId 商品主键id
     * @return map
     */
    Map<String, Object> findDetailById(Integer jcookGoodsId);

    /**
     * 查询商品详情 bigInfo大图信息【加载太慢了所以异步查询该接口】
     * @param jcookGoodsId 商品主键id
     * @return map
     */
    Map<String, Object> findGoodsDetailBigInfo(Integer jcookGoodsId);

    /**
     * 修改商品价格
     * @param manageJcookUpdatePriceDTO 修改商品价格 DTO
     * @return map
     */
    Map<String, Object> updatePrice(ManageJcookUpdatePriceDTO manageJcookUpdatePriceDTO);
}
