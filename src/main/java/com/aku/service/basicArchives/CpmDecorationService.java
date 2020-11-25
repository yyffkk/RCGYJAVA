package com.aku.service.basicArchives;

import com.aku.model.basicArchives.DecorationAndStaff;
import com.aku.model.basicArchives.DecorationIdAndStaffId;
import com.aku.model.basicArchives.SearchDecoration;
import com.aku.vo.basicArchives.VoDecoration;

import java.util.List;
import java.util.Map;

public interface CpmDecorationService {
    List<VoDecoration> list(SearchDecoration searchDecoration);

    Map<String, Object> insert(DecorationAndStaff decorationAndStaff);

    Map<String, Object> update(DecorationAndStaff decorationAndStaff);

    DecorationAndStaff findById(Integer id);

    Map<String, Object> delete(Integer id);

    Map<String, Object> deleteStaff(DecorationIdAndStaffId decorationIdAndStaffId);
}
