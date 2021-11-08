package com.api.app.service.jcook;

import java.util.Map;

public interface AppJcookService {
    /**
     * 查询SKU总数
     * @return map
     */
    Map<String, Object> skuTotal();

    /**
     * 查询入驻品牌数
     * @return map
     */
    Map<String, Object> settledBrandsNum();

    /**
     * 查询今日上新产品件数
     * @return map
     */
    Map<String, Object> newProductsTodayNum();
}
