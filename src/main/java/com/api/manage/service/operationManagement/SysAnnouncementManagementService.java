package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SearchAnnouncementManagement;
import com.api.model.operationManagement.SysAnnouncementManagement;
import com.api.vo.operationManagement.VoAnnouncementManagement;
import com.api.vo.operationManagement.VoFindByIdAnnouncementManagement;
import com.api.vo.operationManagement.VoPreviewAnnouncementManagement;

import java.util.List;
import java.util.Map;

public interface SysAnnouncementManagementService {
    List<VoAnnouncementManagement> list(SearchAnnouncementManagement searchAnnouncementManagement);

    VoFindByIdAnnouncementManagement findById(Integer id);

    Map<String, Object> insert(SysAnnouncementManagement sysAnnouncementManagement);

    Map<String, Object> update(SysAnnouncementManagement sysAnnouncementManagement);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> release(int[] ids);

    VoPreviewAnnouncementManagement preview(Integer id);
}
