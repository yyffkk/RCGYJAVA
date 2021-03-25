package com.api.app.service.my.impl;

import com.api.app.dao.my.MyCarDao;
import com.api.app.service.my.MyCarService;
import com.api.vo.my.MyCarVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyCarServiceImpl implements MyCarService {
    @Resource
    MyCarDao myCarDao;

    @Override
    public List<MyCarVo> list(Integer id) {
        return myCarDao.list(id);
    }
}
