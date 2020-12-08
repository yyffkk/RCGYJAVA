package com.api.dao.resources;

import com.api.model.resources.ResourcesImg;
import com.api.vo.resources.VoResourcesImg;

import java.util.List;

public interface ResourcesImgDao {
    /**
     * 根据条件查询照片信息
     * @param resourcesImg 条件
     * @return 照片信息集合
     */
    List<VoResourcesImg> findImgByDate(ResourcesImg resourcesImg);

    /**
     * 根据条件查询照片数量
     * @param resourcesImg 条件
     * @return 照片数量
     */
    int countByData(ResourcesImg resourcesImg);

    /**
     * 新增照片信息
     * @param resourcesImg 新照片信息
     * @return 影响行数
     */
    int insert(ResourcesImg resourcesImg);

    /**
     * 根据条件删除照片信息
     * @param resourcesImg 条件
     * @return 影响行数
     */
    int deleteImgByDate(ResourcesImg resourcesImg);
}
