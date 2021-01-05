package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.ReleaseDateAndId;
import com.api.model.operationManagement.SearchAnnouncementManagement;
import com.api.model.operationManagement.SysAnnouncementManagement;
import com.api.vo.operationManagement.VoAnnouncementManagement;
import com.api.vo.operationManagement.VoFindByIdAnnouncementManagement;
import com.api.vo.operationManagement.VoPreviewAnnouncementManagement;

import java.util.List;

public interface SysAnnouncementManagementDao {
    /**
     * 查询所有公告信息 （包含条件搜索）
     * @param searchAnnouncementManagement 搜索条件
     * @return 公告信息集合
     */
    List<VoAnnouncementManagement> list(SearchAnnouncementManagement searchAnnouncementManagement);

    /**
     * 根据主键id查询公告信息
     * @param id 主键id
     * @return 公告信息
     */
    VoFindByIdAnnouncementManagement findById(Integer id);

    /**
     * 添加公告信息
     * @param sysAnnouncementManagement 公告信息
     * @return 影响行数
     */
    int insert(SysAnnouncementManagement sysAnnouncementManagement);

    /**
     * 修改公告信息
     * @param sysAnnouncementManagement 新公告信息
     * @return 影响行数
     */
    int update(SysAnnouncementManagement sysAnnouncementManagement);

    /**
     * 根据主键id删除公告管理
     * @param id 主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 发布公告管理信息
     * @param previewDateAndId 发布时间和主键id
     * @return 影响行数
     */
    int release(ReleaseDateAndId previewDateAndId);

    /**
     * 公告信息预览
     * @param id 主键id
     * @return 公告管理预览Vo 回显
     */
    VoPreviewAnnouncementManagement preview(Integer id);
}
