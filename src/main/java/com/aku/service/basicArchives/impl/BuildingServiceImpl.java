package com.aku.service.basicArchives.impl;

import com.aku.dao.basicArchives.BuildingDao;
import com.aku.model.basicArchives.TestBuilding;
import com.aku.service.basicArchives.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    BuildingDao buildingDao;

    private final Map<String,Object> map = new HashMap<>();

    @Override
    public List<TestBuilding> list(TestBuilding testBuilding) {
        return buildingDao.list(testBuilding);
    }

    @Override
    public Map<String, Object> insert(TestBuilding testBuilding) {
        String id = UUID.randomUUID().toString();
        testBuilding.setId(id);
        List<TestBuilding> listByNumber = buildingDao.list(new TestBuilding(null, testBuilding.getNumber(), null));
        if (listByNumber.size() > 0){
            map.put("message","编号已存在");
            map.put("status",false);
            return map;
        }

        List<TestBuilding> listByName = buildingDao.list(new TestBuilding(null,  null,testBuilding.getName()));
        if (listByName.size() > 0){
            map.put("message","楼栋名称已存在");
            map.put("status",false);
            return map;
        }

        int insert = buildingDao.insert(testBuilding);
//        Map<String,Object> map = new HashMap<>();
        if (insert>0){
            map.put("message","添加楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","添加楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public TestBuilding listById(String id) {
        return buildingDao.listById(id);
    }

    @Override
    public Map<String, Object> update(TestBuilding testBuilding) {
        int update = buildingDao.update(testBuilding);
//        Map<String,Object> map = new HashMap<>();
        if (update>0){
            map.put("message","更新楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","更新楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(String id) {
        int delete = buildingDao.delete(id);
        if (delete>0){
            map.put("message","删除楼栋信息成功");
            map.put("status",true);
        }else {
            map.put("message","删除楼栋信息失败");
            map.put("status",false);
        }
        return map;
    }
}
