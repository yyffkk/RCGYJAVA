package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.NotificationManagement;
import com.api.model.operationManagement.SearchNotificationManagement;
import com.api.vo.operationManagement.VoFindByIdNotificationManagement;
import com.api.vo.operationManagement.VoNotificationManagement;

import java.util.List;
import java.util.Map;

public interface SysNotificationManagementService {
    List<VoNotificationManagement> list(SearchNotificationManagement searchNotificationManagement);

    Map<String, Object> insert(NotificationManagement notificationManagement);

    VoFindByIdNotificationManagement findById(Integer id);

    Map<String, Object> update(NotificationManagement notificationManagement);

    Map<String, Object> delete(int[] ids);
}
