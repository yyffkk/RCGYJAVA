package com.api.manage.service.jcook;

import com.api.model.jcook.manageDto.ManageJcookRotationInsertDTO;
import com.api.model.jcook.manageDto.ManageJcookRotationUpdateDTO;

import java.util.Map;

public interface JcookRotationService {
    /**
     * 添加初始轮播图
     * @param manageJcookRotationInsertDTO 添加轮播图DTO
     * @return map
     */
    Map<String, Object> insert(ManageJcookRotationInsertDTO manageJcookRotationInsertDTO);

    /**
     * 修改轮播图
     * @param manageJcookRotationUpdateDTO 修改轮播图DTO
     * @return map
     */
    Map<String, Object> update(ManageJcookRotationUpdateDTO manageJcookRotationUpdateDTO);

    /**
     * 删除轮播图
     * @return map
     */
    Map<String, Object> delete(Integer rotationId);

    /**
     * 查询轮播图信息集合
     * @return map
     */
    Map<String, Object> findRotationList();

}
