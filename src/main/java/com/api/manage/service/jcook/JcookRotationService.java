package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookRotationUpdateDTO;

import java.util.Map;

public interface JcookRotationService {
    /**
     * 添加初始轮播图
     * @return map
     */
    Map<String, Object> insert();

    /**
     * 修改轮播图
     * @param manageJcookRotationUpdateDTO 修改轮播图DTO
     * @return map
     */
    Map<String, Object> update(ManageJcookRotationUpdateDTO manageJcookRotationUpdateDTO);
}
