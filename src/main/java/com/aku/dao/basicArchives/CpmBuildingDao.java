package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmBuilding;
import com.aku.vo.basicArchives.VoFindAll;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmBuildingDao {
    List<CpmBuilding> list(CpmBuilding cpmBuilding);

    int insert(CpmBuilding cpmBuilding);

    CpmBuilding findById(Integer id);

    int update(CpmBuilding cpmBuilding);

    int delete(Integer id);

    List<VoFindAll> findAll();
}
