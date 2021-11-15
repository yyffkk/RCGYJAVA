package com.api.app.service.jcook;

import java.util.Map;

public interface AppJcookCollectionService {
    /**
     * 我的收藏夹
     * @param id 用户主键id
     * @return map
     */
    Map<String, Object> myCollection(Integer id);
}
