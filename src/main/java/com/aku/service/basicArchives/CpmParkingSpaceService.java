package com.aku.service.basicArchives;

import com.aku.model.basicArchives.CpmParkingSpace;
import com.aku.vo.basicArchives.VoCpmParkingSpace;
import com.aku.vo.basicArchives.VoParkingSpace;

import java.util.List;
import java.util.Map;

public interface CpmParkingSpaceService {
    List<VoParkingSpace> list(VoCpmParkingSpace voCpmParkingSpace);

    Map<String, Object> insert(CpmParkingSpace cpmParkingSpace);

    CpmParkingSpace findById(Integer id);

    Map<String, Object> update(CpmParkingSpace cpmParkingSpace);

    Map<String, Object> delete(int[] id);
}
