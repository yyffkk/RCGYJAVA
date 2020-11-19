package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmParkingSpace;
import com.aku.vo.basicArchives.VoCpmParkingSpace;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmParkingSpaceDao {
    List<VoCpmParkingSpace> list(VoCpmParkingSpace voCpmParkingSpace);

    int insert(CpmParkingSpace cpmParkingSpace);

    CpmParkingSpace findById(Integer id);

    int update(CpmParkingSpace cpmParkingSpace);

    int delete(Integer id);

    List<CpmParkingSpace>  findByResidentId(Integer id);
}
