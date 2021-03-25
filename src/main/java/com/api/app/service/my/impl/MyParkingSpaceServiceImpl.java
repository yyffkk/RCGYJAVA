package com.api.app.service.my.impl;

import com.api.app.dao.my.MyParkingSpaceDao;
import com.api.app.service.my.MyParkingSpaceService;
import com.api.model.my.MyParkingSpace;
import com.api.vo.my.MyParkingSpaceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyParkingSpaceServiceImpl implements MyParkingSpaceService {
    @Resource
    MyParkingSpaceDao myParkingSpaceDao;
    private static Map<String,Object> map = null;

    @Override
    public List<MyParkingSpaceVo> list(Integer id) {
        return myParkingSpaceDao.list(id);
    }

}
