package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppAlarmDao;
import com.api.app.service.butler.AppAlarmService;
import com.api.model.app.AppAlarm;
import com.api.util.webSocket.WebSocketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppAlarmServiceImpl implements AppAlarmService {
    private static Map<String,Object> map = null;
    @Resource
    AppAlarmDao appAlarmDao;

    @Override
    public Map<String, Object> insertAlarmRecord(AppAlarm appAlarm) {
        map = new HashMap<>();

        String roomName = appAlarmDao.findRoomNameByEstateId(appAlarm.getEstateId());
        String name = appAlarmDao.findNameByResidentId(appAlarm.getCreateId());

        String content = "于【"+roomName+"】的【"+name+"】使用了一键报警功能";
        WebSocketService ws = new WebSocketService();
        ws.broadcast(content);

        int insert = appAlarmDao.insertAlarmRecord(appAlarm);
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
