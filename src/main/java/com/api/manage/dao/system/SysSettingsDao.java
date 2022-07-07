package com.api.manage.dao.system;

import com.api.model.system.SysSettings;

import java.util.List;

public interface SysSettingsDao {
    /**
     * 查询系统设置开关信息
     * @return 系统设置开关信息
     */
    List<SysSettings> list();

    /**
     * 根据主键id查询 按钮开关状态
     * @param id 主键id
     * @return 按钮开关：1.开启，2.关闭
     */
    Integer findOnOffById(Integer id);

    /**
     * 关闭开关
     * @return 影响行数
     * @param id
     */
    int disEnable(Integer id);

    /**
     * 开启开关
     * @return 影响行数
     * @param id
     */
    int enable(Integer id);

}
