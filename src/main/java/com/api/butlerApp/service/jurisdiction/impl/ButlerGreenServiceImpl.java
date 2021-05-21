package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerGreenDao;
import com.api.butlerApp.service.jurisdiction.ButlerGreenService;
import com.api.model.butlerApp.ButlerGreenSearch;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.butlerApp.ButlerGreenVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerGreenServiceImpl implements ButlerGreenService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerGreenDao butlerGreenDao;

    @Override
    public List<ButlerGreenVo> list(ButlerGreenSearch butlerGreenSearch) {
        return butlerGreenDao.list(butlerGreenSearch);
    }

    @Override
    public Map<String, Object> complete(SysGreenTask sysGreenTask) {
        map = new HashMap<>();


        sysGreenTask.setStatus(2);//2.已完成
        sysGreenTask.setComplete(new Date());//填入完成时间

        int update = butlerGreenDao.complete(sysGreenTask);
        if (update >0){
            map.put("message","完成成功");
            map.put("status",true);
        }else {
            map.put("message","完成失败");
            map.put("status",false);
        }

        return map;
    }
}
