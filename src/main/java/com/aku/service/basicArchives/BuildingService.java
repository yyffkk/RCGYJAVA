package com.aku.service.basicArchives;

import com.aku.model.basicArchives.TestBuilding;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<TestBuilding> list(TestBuilding testBuilding);

    Map<String, Object> insert(TestBuilding testBuilding);

    TestBuilding listById(String id);

    Map<String, Object> update(TestBuilding testBuilding);

    Map<String, Object> delete(String id);
}
