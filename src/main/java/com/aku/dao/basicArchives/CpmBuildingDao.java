package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuilding;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingDao {
    List<CpmBuilding> list(CpmBuilding cpmBuilding);
}
