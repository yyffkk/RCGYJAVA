package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerAlarmDao;
import com.api.butlerApp.service.butler.ButlerAlarmService;
import com.api.model.butlerApp.ButlerAppAlarm;
import com.api.util.webSocket.WebSocketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ButlerAlarmServiceImpl implements ButlerAlarmService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerAlarmDao butlerAlarmDao;

    @Override
    public Map<String, Object> insertAlarmRecord(ButlerAppAlarm butlerAppAlarm) {
        map = new HashMap<>();

        //根据用户主键id查询部门名称
        String organizationName = butlerAlarmDao.findOrganizationByUserId(butlerAppAlarm.getCreateId());
        //根据用户主键id查询用户名称
        String name = butlerAlarmDao.findNameByUserId(butlerAppAlarm.getCreateId());

        if (organizationName == null){
            organizationName = "暂无部门";
        }

        if (name == null){
            name = "暂无名称";
        }


        String content = "于【"+organizationName+"】的【"+name+"】使用了一键报警功能";
        WebSocketService ws = new WebSocketService();
        ws.broadcast(content);

        int insert = butlerAlarmDao.insertAlarmRecord(butlerAppAlarm);
        if (insert >0){
            map.put("message","记录成功");
            map.put("status",true);
        }else {
            map.put("message","记录失败");
            map.put("status",false);
        }
        return map;
    }
}
