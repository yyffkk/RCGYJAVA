package com.api.app.service.my;

import com.api.vo.my.MyCarVo;

import java.util.List;

public interface MyCarService {
    List<MyCarVo> list(Integer id);
}
