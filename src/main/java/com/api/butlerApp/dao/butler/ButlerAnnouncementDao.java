package com.api.butlerApp.dao.butler;

import com.api.model.app.TypeAndAnnouncementId;
import com.api.model.app.TypeAndNowDate;
import com.api.vo.butlerApp.ButlerAnnouncementDetailVo;
import com.api.vo.butlerApp.ButlerAnnouncementVo;

import java.util.List;

public interface ButlerAnnouncementDao {
    /**
     * 管家app 查询所有的社区公告
     * @param typeAndNowDate 用户类型 和 当前时间
     * @return 管家app 社区公告Vo list 回显
     */
    List<ButlerAnnouncementVo> list(TypeAndNowDate typeAndNowDate);

    /**
     * 管家app，根据社区公告主键id查询社区公告信息
     * @param typeAndAnnouncementId 用户类型 和 社区公告主键id
     * @return app社区公告详情信息Vo 回显
     */
    ButlerAnnouncementDetailVo findById(TypeAndAnnouncementId typeAndAnnouncementId);
}
