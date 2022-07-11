package com.api.app.service.jcook;

import com.api.model.jcook.appDto.CollectionDTO;

import java.util.Map;

public interface AppJcookCollectionService {
    /**
     * 我的收藏夹
     * @param id 用户主键id
     * @return map
     */
    Map<String, Object> myCollection(Integer id);

    /**
     * 加入收藏
     * @param collectionDTO 加入收藏DTO
     * @return map
     */
    Map<String, Object> collection(CollectionDTO collectionDTO);
}
