package com.api.app.service.my;

import com.api.vo.my.MyCarVo;

import java.util.List;
import java.util.Map;

public interface MyCarService {
    Map<String,Object> list(Integer estateId);
}
