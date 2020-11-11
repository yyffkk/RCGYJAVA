package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.HouseDao;
import com.aku.model.basicArchives.TestHouse;
import com.aku.service.basicArchives.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Resource
    HouseDao houseDao;

    @Override
    public List<TestHouse> list(TestHouse testHouse) {
        return houseDao.list(testHouse);
    }
}
