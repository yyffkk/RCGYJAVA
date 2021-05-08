package com.api.manage.dao.shoppingCenter;

import com.api.model.shoppingCenter.Goods;
import com.api.model.shoppingCenter.GoodsIdAndStatus;
import com.api.model.shoppingCenter.GoodsSearch;
import com.api.vo.shoppingCenter.GoodsVo;

import java.util.List;
import java.util.Map;

/**
 * 商品管理
 */
public interface GoodsDao {
    /**
     * 查询所有的商品信息
     * @param goodsSearch 商品管理 搜索条件
     * @return 商品信息
     */
    List<GoodsVo> list(GoodsSearch goodsSearch);

    /**
     * 添加商品信息
     * @param goods 商品信息
     * @return map
     */
    int insert(Goods goods);

    /**
     * 修改上下架状态
     * @param goodsIdAndStatus 商品主键id和上下架状态
     * @return 影响行数
     */
    int updateStatus(GoodsIdAndStatus goodsIdAndStatus);

    /**
     * 假删除商品信息
     * @param id 商品主键id
     * @return  影响行数
     */
    int delete(int id);
}
