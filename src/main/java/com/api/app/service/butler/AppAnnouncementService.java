package com.api.app.service.butler;

import com.api.vo.app.AppAnnouncementVo;

import java.util.List;
import java.util.Map;

public interface AppAnnouncementService {
    List<AppAnnouncementVo> list(int type);

    Map<String, Object> findById(Integer announcementId, Integer type);
}
