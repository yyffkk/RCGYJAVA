package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.UnitDao;
import com.aku.model.basicArchives.TestUnit;
import com.aku.model.vo.VoUnit;
import com.aku.service.basicArchives.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    UnitDao unitDao;

    private final Map<String,Object> map = new HashMap<>();

    @Override
    public List<VoUnit> list(VoUnit voUnit) {
        return unitDao.list(voUnit);
    }

    @Override
    public Map<String, Object> insert(TestUnit testUnit) {
        int insert = unitDao.insert(testUnit);
        if (insert>0){
            map.put("message","添加单元信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加单元信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public TestUnit findById(Integer id) {
        return unitDao.findById(id);
    }
}
