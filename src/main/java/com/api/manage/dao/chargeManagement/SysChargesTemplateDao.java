package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.ChargesTemplate;
import com.api.vo.chargeManagement.VoChargesTemplate;

import java.util.List;

public interface SysChargesTemplateDao {
    /**
     * 查询所有的物业收费标准模版
     * @return 物业收费标准模版集合
     */
    List<VoChargesTemplate> list();

    /**
     * 添加物业收费标准模版
     * @param chargesTemplate 物业收费标准模版信息
     * @return 影响行数
     */
    int insert(ChargesTemplate chargesTemplate);

    /**
     * 根据收费标准模版主键id删除收费标准模版信息
     * @param id 收费标准模版主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据收费标准模版主键id查询收费标准模版信息
     * @param id 收费标准模版主键id
     * @return 收费标准模版信息
     */
    VoChargesTemplate findById(Integer id);

    /**
     * 更新物业收费标准模版信息
     * @param chargesTemplate 新物业收费标准模版信息
     * @return 影响行数
     */
    int update(ChargesTemplate chargesTemplate);

    /**
     * 禁用所有的物业收费标准模版
     * @return 影响行数
     */
    int disableAll();

    /**
     * 根据物业收费标准模版主键id 启用物业收费标准模版
     * @param id 物业收费标准模版主键id
     * @return 影响行数
     */
    int enable(Integer id);

    /**
     * 根据物业收费标准模版主键id 禁用物业收费标准模版
     * @param id 物业收费标准模版主键id
     * @return 影响行数
     */
    int disable(Integer id);
}
