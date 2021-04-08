package com.api.butlerApp.controller.personalData;

import com.api.app.service.my.FeedbackService;
import com.api.model.butlerService.SysAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 管家app 意见反馈
 */
@RestController
@RequestMapping("butlerApp/user/feedback")
public class ButlerFeedbackController {
    @Resource
    FeedbackService feedbackService;
    /**
     * 管家app意见反馈提交（建议）
     * @param sysAdvice 咨询建议表信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/submit")
    public Map<String,Object> submit(@RequestBody SysAdvice sysAdvice, HttpServletRequest request){
        //从request获取物业用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入创建人
        sysAdvice.setCreateId(id);
        //填入创建时间
        sysAdvice.setCreateDate(new Date());
        //填入创建人类型（1.住户，2.装修公司,3.物业）,1.住户
        sysAdvice.setCreateUserType(3);
        //填入默认点击数 0
        sysAdvice.setHits(0);
        //填入状态（1.未反馈，2.反馈中，3.已反馈）,默认1.未反馈
        sysAdvice.setStatus(1);
        //填入类型(1.咨询，2.建议，3.投诉，4.表扬)，默认2.建议
        sysAdvice.setType(2);
        //填入是否删除 ，默认1.非删
        sysAdvice.setIsDelete(1);
        //填入用户端是否删除 ，默认1.非删
        sysAdvice.setUserDelete(1);
        return feedbackService.submit(sysAdvice);
    }
}
