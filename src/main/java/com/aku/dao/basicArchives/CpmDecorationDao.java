package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmDecoration;
import com.aku.model.basicArchives.SearchDecoration;
import com.aku.model.basicArchives.UserStaff;
import com.aku.vo.basicArchives.VoDecoration;

import java.util.List;
import java.util.Map;

public interface CpmDecorationDao {
    List<VoDecoration> list(SearchDecoration searchDecoration);

    int insert(CpmDecoration cpmDecoration);

    int update(CpmDecoration cpmDecoration);

    CpmDecoration findById(Integer id);

    int deleteById(Integer id);
}
