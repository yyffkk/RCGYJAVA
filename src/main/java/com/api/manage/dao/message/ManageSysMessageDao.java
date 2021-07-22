package com.api.manage.dao.message;

import com.api.model.businessManagement.SysOrganization;
import com.api.model.message.ManageSysMessage;
import com.api.model.message.SearchManageSysMessage;

import java.util.List;

public interface ManageSysMessageDao {
    /**
     * 查询所有的消息列表信息（包含条件搜索）
     * @param searchManageSysMessage 后台消息列表 搜索条件
     * @return 消息列表信息
     */
    List<ManageSysMessage> list(SearchManageSysMessage searchManageSysMessage);

    /**
     * 添加后台消息列表
     * @param manageSysMessage 后台消息列表 model
     * @return 影响行数
     */
    int insert(ManageSysMessage manageSysMessage);

    /**
     * 根据组织id查询组织信息
     * @param organizationId 组织id
     * @return 组织信息
     */
    SysOrganization findOrganizationByOrganizationId(Integer organizationId);
}
