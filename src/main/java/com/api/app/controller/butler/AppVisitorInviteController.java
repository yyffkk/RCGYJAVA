package com.api.app.controller.butler;

import com.api.app.service.butler.AppVisitorInviteService;
import com.api.model.app.AppUserVisitorsInvite;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * app 新版的访客邀请管理-人脸识别版 和 二维码版
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
    public Map<String,Object> share(@RequestBody AppUserVisitorsInvite visitorsInvite, HttpServletRequest request) {
        //处理预计到访时间开始 和 预计到访时间结束
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (visitorsInvite.getVisitDateStart() != null){
                visitorsInvite.setVisitDateStart(simpleDateFormat.parse(DateFormatUtils.format(visitorsInvite.getVisitDateStart(),"yyyy-MM-dd 00:00:00")));
                visitorsInvite.setVisitDateEnd(simpleDateFormat.parse(DateFormatUtils.format(visitorsInvite.getVisitDateStart(),"yyyy-MM-dd 23:59:59")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        visitorsInvite.setCreateId(id); //填写创建人
        visitorsInvite.setCreateDate(new Date()); //填写创建时间
        return appVisitorInviteService.share(visitorsInvite);
    }
}
