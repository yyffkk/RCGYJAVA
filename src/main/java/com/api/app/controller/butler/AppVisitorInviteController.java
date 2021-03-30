package com.api.app.controller.butler;

import com.api.app.service.butler.AppVisitorInviteService;
import com.api.model.app.AppUserVisitorsInvite;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * app 新版的访客邀请管理
 */
@RestController
@RequestMapping("app/user/visitorInvite")
public class AppVisitorInviteController {
    @Resource
    AppVisitorInviteService appVisitorInviteService;


    /**
     * 访客邀请信息分享
     * @param visitorsInvite app 访客邀请填写信息 model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/share")
    public Map<String,Object> share(@RequestBody AppUserVisitorsInvite visitorsInvite, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        visitorsInvite.setCreateId(id); //填写创建人
        visitorsInvite.setCreateDate(new Date()); //填写创建时间
        return appVisitorInviteService.share(visitorsInvite);
    }
}
