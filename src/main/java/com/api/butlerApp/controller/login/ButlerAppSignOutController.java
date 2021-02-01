package com.api.butlerApp.controller.login;

import com.api.butlerApp.service.login.ButlerAppSignOutService;
import com.api.butlerApp.service.login.ButlerLoginService;
import com.api.model.butlerApp.ButlerLoginToken;
import com.api.vo.app.UserLoginTokenVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("butlerApp/user")
public class ButlerAppSignOutController {
    @Resource
    ButlerAppSignOutService butlerAppSignOutService;
    @Resource
    ButlerLoginService butlerLoginService;

    /**
     * 管家用户退出账户
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @GetMapping("/signOut")
    public Map<String,Object> signOut(HttpServletRequest request){
        //获取token信息
        String tokenId = request.getHeader("butlerApp-admin-token");
        //根据token Id查询登录信息 (user_login_token)
        ButlerLoginToken butlerLoginToken = butlerLoginService.findBLTByTokenId(Long.valueOf(tokenId));
        return butlerAppSignOutService.signOut(butlerLoginToken.getId());
    }
}
