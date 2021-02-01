package com.api.butlerApp.controller.login;

import com.api.butlerApp.service.login.ButlerLoginService;
import com.api.model.butlerApp.ButlerUserCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("butlerApp/login")
public class ButlerLoginController {
    @Resource
    ButlerLoginService butlerLoginService;

    /**
     * 发送短信验证码
     * @param butlerUserCode 管家app用户验证码
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/sendMMSLogin")
    public Map<String,Object> sendMMSLogin (@RequestBody ButlerUserCode butlerUserCode){
        return butlerLoginService.sendMMSLogin (butlerUserCode);
    }

    /**
     * app用户短信登录
     * @param butlerUserCode 管家app用户验证码
     * @return map {message 消息, status 状态}
     */
    @PostMapping("/loginSMSUser")
    public Map<String,Object> loginSMSUser(@RequestBody ButlerUserCode butlerUserCode){
        return butlerLoginService.loginSMSUser(butlerUserCode);
    }
}
