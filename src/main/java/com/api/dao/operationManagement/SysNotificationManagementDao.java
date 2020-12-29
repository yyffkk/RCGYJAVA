package com.api.dao.operationManagement;

import com.api.model.operationManagement.NotificationManagement;
import com.api.model.operationManagement.SearchNotificationManagement;
import com.api.vo.operationManagement.VoFindByIdNotificationManagement;
import com.api.vo.operationManagement.VoNotificationManagement;

import java.util.List;

public interface SysNotificationManagementDao {
    /**
     * 查询所有的通知信息（包含条件搜索）
     * @param searchNotificationManagement 搜索条件
     * @return 通知信息集合
     */
    List<VoNotificationManagement> list(SearchNotificationManagement searchNotificationManagement);

    /**
     * 添加通知管理信息
     * @param notificationManagement 通知管理信息
     * @return 影响行数
     */
    int insert(NotificationManagement notificationManagement);

    /**
     * 根据主键id查询通知信息
     * @param id 主键id
     * @return 通知信息
     */
    VoFindByIdNotificationManagement findById(Integer id);

    /**
     * 修改通知信息
     * @param notificationManagement 新通知信息
     * @return 影响行数
     */
    int update(NotificationManagement notificationManagement);

    /**
     * 根据主键id删除通知信息
     * @param id 主键id
     * @return 影响行数
     */
    int delete(int id);
}
