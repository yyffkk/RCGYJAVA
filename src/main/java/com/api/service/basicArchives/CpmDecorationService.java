package com.api.service.basicArchives;

import com.api.model.basicArchives.DecorationAndStaff;
import com.api.model.basicArchives.DecorationIdAndStaffId;
import com.api.model.basicArchives.SearchDecoration;
import com.api.vo.basicArchives.VoDecoration;

import java.util.List;
import java.util.Map;

public interface CpmDecorationService {
    List<VoDecoration> list(SearchDecoration searchDecoration);

    Map<String, Object> insert(DecorationAndStaff decorationAndStaff);

    Map<String, Object> update(DecorationAndStaff decorationAndStaff);

    DecorationAndStaff findById(Integer id);

    Map<String, Object> delete(int[] id);

    Map<String, Object> deleteStaff(DecorationIdAndStaffId decorationIdAndStaffId);
}
