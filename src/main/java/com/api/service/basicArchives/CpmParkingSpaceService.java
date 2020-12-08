package com.api.service.basicArchives;

import com.api.model.basicArchives.CpmParkingSpace;
import com.api.vo.basicArchives.VoCpmParkingSpace;
import com.api.vo.basicArchives.VoParkingSpace;

import java.util.List;
import java.util.Map;

public interface CpmParkingSpaceService {
    List<VoParkingSpace> list(VoCpmParkingSpace voCpmParkingSpace);

    Map<String, Object> insert(CpmParkingSpace cpmParkingSpace);

    CpmParkingSpace findById(Integer id);

    Map<String, Object> update(CpmParkingSpace cpmParkingSpace);

    Map<String, Object> delete(int[] id);
}
