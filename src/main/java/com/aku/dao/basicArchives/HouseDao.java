package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.TestHouse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HouseDao {
    List<TestHouse> list(TestHouse testHouse);
}
