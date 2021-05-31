package com.api.app.service.my;

import com.api.model.my.MyHouse;

import java.util.Map;

public interface MyHouseService {
    Map<String, Object> houseList(Integer id);

    Map<String, Object> examineList(Integer id);

    Map<String, Object> authentication(MyHouse myHouse, Integer type);

    Map<String, Object> falseDelete(int[] ids,Integer residentId);

    Map<String, Object> findById(Integer estateExamineId);

    Map<String, Object> changeSelectExamineId(Integer examineId, Integer id);
}
