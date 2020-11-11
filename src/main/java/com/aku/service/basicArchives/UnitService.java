package com.aku.service.basicArchives;

import com.aku.model.basicArchives.TestUnit;
import com.aku.model.vo.VoUnit;

import java.util.List;
import java.util.Map;

public interface UnitService {
    List<VoUnit> list(VoUnit voUnit);

    Map<String, Object> insert(TestUnit testUnit);

    TestUnit findById(Integer id);

    Map<String, Object> update(TestUnit testUnit);

    Map<String, Object> delete(Integer id);
}
