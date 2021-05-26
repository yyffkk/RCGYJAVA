package com.api.butlerApp.controller.butler;

import com.api.butlerApp.service.butler.ButlerAlarmService;
import com.api.model.butlerApp.ButlerAppAlarm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * app 一键报警
 */
@RestController
@RequestMapping("butlerApp/user/alarm")
public class ButlerAlarmController {
    @Resource
    ButlerAlarmService butlerAlarmService;


    /**
     * 添加管家app报警记录
     * @param butlerAppAlarm 管家app 报警model 信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insertAlarmRecord")
    public Map<String,Object> insertAlarmRecord(@RequestBody ButlerAppAlarm butlerAppAlarm, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        butlerAppAlarm.setCreateId(id);
        butlerAppAlarm.setCreateDate(new Date());
        return butlerAlarmService.insertAlarmRecord(butlerAppAlarm);
    }
}
