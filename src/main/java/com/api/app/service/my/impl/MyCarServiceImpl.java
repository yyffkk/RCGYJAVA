package com.api.app.service.my.impl;

import com.api.app.dao.my.MyCarDao;
import com.api.app.service.my.MyCarService;
import com.api.vo.my.MyCarVo;
import com.api.vo.my.MyHouseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyCarServiceImpl implements MyCarService {
    @Resource
    MyCarDao myCarDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String,Object> list(Integer estateId) {
        map = new HashMap<>();
        List<MyCarVo> list = myCarDao.list(estateId);
        map.put("data",list);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }
}
