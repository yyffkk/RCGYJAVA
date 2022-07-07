package com.api.manage.service.shoppingCenter;


import com.api.model.shoppingCenter.Goods;
import com.api.model.shoppingCenter.GoodsSearch;
import com.api.vo.shoppingCenter.GoodsVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<GoodsVo> list(GoodsSearch goodsSearch);

    Map<String, Object> insert(Goods goods);

    Map<String, Object> unloading(Integer id);

    Map<String, Object> loading(Integer id);

    Map<String, Object> delete(int[] ids);
}
