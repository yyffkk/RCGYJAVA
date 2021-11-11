package com.api.butlerApp.service.butler.impl;

import com.alibaba.fastjson.JSON;
import com.api.butlerApp.dao.butler.ButlerAlarmDao;
import com.api.butlerApp.service.butler.ButlerAlarmService;
import com.api.model.butlerApp.ButlerAppAlarm;
import com.api.util.webSocket.WebSocketService;
import com.api.util.webSocket.WebSocketServiceApp;
import com.api.util.webSocket.WebSocketServiceButlerApp;
import com.api.vo.systemDataBigScreen.WebSocketFirePushAlert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        //根据用户主键id查询用户手机号
        String tel = butlerAlarmDao.findTelByUserId(butlerAppAlarm.getCreateId());

        if (organizationName == null){
            organizationName = "暂无部门";
        }

        if (name == null){
            name = "暂无名称";
        }

        //        String content = "于【"+organizationName+"】的【"+name+"】使用了一键报警功能";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date().getTime());
        WebSocketFirePushAlert webSocketFirePushAlert = new WebSocketFirePushAlert();
        webSocketFirePushAlert.setDeviceNo(organizationName);//填入设备号
        webSocketFirePushAlert.setAlarmNo(tel);//填入报警号
        webSocketFirePushAlert.setAlarmType("C");//填入数值报警，还是状态报警(C:数值报警，X:状态报警)
        webSocketFirePushAlert.setDeviceName(name);//填入设备名称
        webSocketFirePushAlert.setTime(format);//填入报警时间
        webSocketFirePushAlert.setType(3);//填入报警类型：1.火灾报警（消防），2.设备报警,3.一键报警
        String content = JSON.toJSONString(webSocketFirePushAlert);

        //web页面的websocket
        WebSocketService ws = new WebSocketService();
        ws.broadcast(content);
        //管家app的websocket
        WebSocketServiceButlerApp wsButlerApp = new WebSocketServiceButlerApp();
        wsButlerApp.broadcast(content);

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
