package com.api.app.service.my;

import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.my.MyHouse;
import com.api.vo.app.AppAdviceVo;
import com.api.vo.my.MyHouseVo;

import java.util.List;
import java.util.Map;

public interface MyHouseService {
    List<MyHouseVo> list(Integer id);

    Map<String, Object> authentication(MyHouse myHouse, Integer type);
}
