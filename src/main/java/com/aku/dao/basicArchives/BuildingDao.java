package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.TestBuilding;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BuildingDao {
    List<TestBuilding> list(TestBuilding testBuilding);

    int insert(TestBuilding testBuilding);

    TestBuilding listById(String id);

    int update(TestBuilding testBuilding);

    int delete(String id);
}
