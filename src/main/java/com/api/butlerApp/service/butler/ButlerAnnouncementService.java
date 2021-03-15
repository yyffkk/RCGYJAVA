package com.api.butlerApp.service.butler;

import com.api.vo.butlerApp.ButlerAnnouncementVo;

import java.util.List;
import java.util.Map;

public interface ButlerAnnouncementService {
    List<ButlerAnnouncementVo> list();

    Map<String, Object> findById(Integer announcementId);
}
