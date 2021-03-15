package com.api.butlerApp.service.jurisdiction;

import com.api.vo.butlerApp.ButlerBacklogVo;

import java.util.List;

public interface ButlerBacklogService {
    List<ButlerBacklogVo> list(String roleId);
}
