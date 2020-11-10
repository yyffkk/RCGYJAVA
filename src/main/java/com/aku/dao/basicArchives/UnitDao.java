package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.TestUnit;
import com.aku.model.vo.VoUnit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UnitDao {
    List<VoUnit> list(VoUnit voUnit);

    int insert(TestUnit testUnit);

    TestUnit findById(Integer id);
}
