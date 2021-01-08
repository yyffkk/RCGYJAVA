package com.api.app.controller.login;

import com.api.app.service.login.AppLoginService;
import com.api.model.app.UserCode;
import com.api.model.basicArchives.UserResident;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("app/login")
public class AppLoginController {
    @Resource
    AppLoginService appLoginService;

    /**
     * 发送短信验证码
     * @param userCode app用户验证码
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (@RequestBody UserCode userCode){
        return appLoginService.sendMMSLogin (userCode);
    }

    /**
     * app用户短信登录
     * @param userCode app用户验证码
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSUser")
    public Map<String,Object> loginSMSUser(@RequestBody UserCode userCode){
        return appLoginService.loginSMSUser(userCode);
    }

    /**
     * app用户注册
     * @param userResident 住户信息表
     * @return map
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody UserResident userResident){
        return appLoginService.register(userResident);
    }
}
