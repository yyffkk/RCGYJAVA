package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerHousekeepingDao;
import com.api.butlerApp.service.butler.ButlerHousekeepingService;
import com.api.model.butlerApp.ButlerHousekeeping;
import com.api.vo.butlerApp.ButlerHousekeepingVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerHousekeepingServiceImpl implements ButlerHousekeepingService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerHousekeepingDao butlerHousekeepingDao;

    @Override
    public List<ButlerHousekeepingVo> list(Integer id) {
        return butlerHousekeepingDao.list(id);
    }

    @Override
    public Map<String, Object> insert(ButlerHousekeeping butlerHousekeeping, Integer id) {
        map = new HashMap<>();

        butlerHousekeeping.setCreateId(id);
        butlerHousekeeping.setCreateDate(new Date());

        int insert = butlerHousekeepingDao.insert(butlerHousekeeping);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }
}
