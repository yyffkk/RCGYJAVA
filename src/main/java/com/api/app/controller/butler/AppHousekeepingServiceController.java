package com.api.app.controller.butler;

import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * app 新版家政服务
 */
@RestController
@RequestMapping("app/user/housekeepingService")
public class AppHousekeepingServiceController {
    @Resource
    AppHousekeepingServiceService appHousekeepingServiceService;

    /**
     * 确认提交家政
     * @param appHousekeepingService app 新版家政服务 model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/submitHousekeeping")
    public Map<String,Object> submitHousekeeping(@RequestBody AppHousekeepingService appHousekeepingService, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        appHousekeepingService.setProposer(id);
        appHousekeepingService.setApplyTime(new Date());
        appHousekeepingService.setCreateId(id);
        appHousekeepingService.setCreateDate(new Date());
        return appHousekeepingServiceService.submitHousekeeping(appHousekeepingService);
    }

}
