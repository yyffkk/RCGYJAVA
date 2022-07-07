package com.api.app.controller.butler;

import com.api.app.service.butler.AppAlarmService;
import com.api.model.app.AppAlarm;
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
@RequestMapping("app/user/alarm")
public class AppAlarmController {
    @Resource
    AppAlarmService appAlarmService;

    /**
     * 添加app报警记录
     * @param appAlarm app 报警model 信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/insertAlarmRecord")
    public Map<String,Object> insertAlarmRecord(@RequestBody AppAlarm appAlarm, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        appAlarm.setCreateId(id);
        appAlarm.setCreateDate(new Date());
        return appAlarmService.insertAlarmRecord(appAlarm);
    }
}
