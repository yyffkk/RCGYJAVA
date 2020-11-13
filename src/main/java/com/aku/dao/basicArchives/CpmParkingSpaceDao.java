package com.aku.dao.basicArchives;

import com.aku.model.basicArchives.CpmParkingSpace;
import com.aku.model.vo.VoCpmParkingSpace;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CpmParkingSpaceDao {
    List<VoCpmParkingSpace> list(VoCpmParkingSpace voCpmParkingSpace);

    int insert(CpmParkingSpace cpmParkingSpace);
}
