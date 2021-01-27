package com.api.app.dao.butler;

import com.api.model.app.TypeAndAnnouncementId;
import com.api.model.app.TypeAndNowDate;
import com.api.vo.app.AppAnnouncementDetailVo;
import com.api.vo.app.AppAnnouncementVo;

import java.util.List;

public interface AppAnnouncementDao {
    /**
     * 查询所有的社区公告
     * @param typeAndNowDate 用户类型 和 当前时间
     * @return 社区公告Vo list 回显
     */
    List<AppAnnouncementVo> list(TypeAndNowDate typeAndNowDate);

    /**
     * 根据社区公告主键id查询社区公告信息
     * @param typeAndAnnouncementId 用户类型 和 社区公告主键id
     * @return 社区公告Vo list 回显
     */
    AppAnnouncementDetailVo findById(TypeAndAnnouncementId typeAndAnnouncementId);
}
