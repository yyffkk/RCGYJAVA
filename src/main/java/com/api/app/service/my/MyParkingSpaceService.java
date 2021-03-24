package com.api.app.service.my;

import com.api.model.my.MyParkingSpace;
import com.api.vo.my.MyParkingSpaceVo;

import java.util.List;
import java.util.Map;

public interface MyParkingSpaceService {
    List<MyParkingSpaceVo> list(Integer id);

    Map<String, Object> authentication(MyParkingSpace myParkingSpace);

    Map<String, Object> falseDelete(int[] ids);
}
