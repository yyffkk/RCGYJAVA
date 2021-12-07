package com.api.manage.service.operationManagement.impl;

import com.alibaba.fastjson.JSON;
import com.api.manage.dao.operationManagement.SysAlarmDao;
import com.api.manage.service.operationManagement.SysAlarmService;
import com.api.util.webSocket.WebSocketService;
import com.api.util.webSocket.WebSocketServiceApp;
import com.api.util.webSocket.WebSocketServiceButlerApp;
import com.api.vo.operationManagement.VoButlerOneButtonAlarm;
import com.api.vo.operationManagement.VoFireAlarm;
import com.api.vo.operationManagement.VoOneButtonAlarm;
import com.api.vo.operationManagement.VoPlanAlarm;
import com.api.vo.systemDataBigScreen.WebSocketFirePushAlert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SysAlarmServiceImpl implements SysAlarmService {
    private static Map<String,Object> map = null;
    @Resource
    SysAlarmDao sysAlarmDao;

    @Override
    public List<VoFireAlarm> fireAlarmList() {
        return sysAlarmDao.fireAlarmList();
    }

    @Override
    public List<VoOneButtonAlarm> oneButtonAlarmList() {
        return sysAlarmDao.oneButtonAlarmList();
    }

    @Override
    public List<VoButlerOneButtonAlarm> butlerOneButtonAlarmList() {
        return sysAlarmDao.butlerOneButtonAlarmList();
    }

    @Override
    public List<VoPlanAlarm> planAlarmList() {
        return sysAlarmDao.planAlarmList();
    }

    @Override
    public Map<String, Object> pushRelieveAlert() {
        map = new HashMap<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(new Date());

            WebSocketFirePushAlert webSocketFirePushAlert = new WebSocketFirePushAlert();
            webSocketFirePushAlert.setTime(format);//填入解除时间
            webSocketFirePushAlert.setPlanContent("当前小区内发生的火灾险情已消除，请大家注意安全，有序返回小区。");//填入预案内容
            webSocketFirePushAlert.setType(5);//填入报警类型：1.火灾报警（消防），2.设备报警，3.一键报警,4.预案报警,5.解除报警


            String content = JSON.toJSONString(webSocketFirePushAlert);

            log.info("解除报警："+content);
    //            System.out.printf(content);
    //             key:type value:1 火警
            //不使用第三方极光推送，改用websocket来实现推送
    //            JiguangUtil.sendPushAll(content,"1");
    //            JiguangUtil.sendButlerPushAll(content,"1");

            //业主app的websocket
            WebSocketServiceApp wsApp = new WebSocketServiceApp();
            wsApp.broadcast(content);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","推送失败");
            map.put("status",false);
            return map;
        }
        map.put("message","推送成功");
        map.put("status",true);
        return map;
    }
}
