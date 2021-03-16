package com.api.butlerApp.service.jurisdiction;

import com.api.vo.butlerApp.ButlerBacklogVo;

import java.util.List;
import java.util.Map;

public interface ButlerBacklogService {
    List<ButlerBacklogVo> list(String roleId, int id);

    Map<String, Object> findItemNum(String roleId, int id);
}
