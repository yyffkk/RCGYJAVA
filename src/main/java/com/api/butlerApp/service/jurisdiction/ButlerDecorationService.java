package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.model.butlerApp.ButlerTrackInspectionCycle;
import com.api.model.butlerApp.ButlerTrackRecord;
import com.api.vo.butlerApp.ButlerDecorationVo;

import java.util.List;
import java.util.Map;

public interface ButlerDecorationService {
    List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch);

    Map<String, Object> findById(Integer decorationId, String roleId);

    Map<String, Object> appoint(ButlerTrackInspectionCycle trackInspectionCycle, Integer id, String roleId);

    Map<String, Object> findTrackChecksDetail(Integer decorationId);

    Map<String, Object> submitTrackExecution(ButlerTrackRecord butlerTrackRecord, Integer id, String roleId);
}
