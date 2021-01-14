package com.api.app.controller.my;

import com.api.app.service.login.AppLoginService;
import com.api.app.service.my.AppSignOutService;
import com.api.vo.app.UserLoginTokenVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("app/user")
public class AppSignOutController {
    @Resource
    AppSignOutService appSignOutService;
    @Resource
    AppLoginService appLoginService;


    /**
     * 用户退出账户
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @GetMapping("/signOut")
    public Map<String,Object> signOut(HttpServletRequest request){
        //获取token信息
        String tokenId = request.getHeader("app-admin-token");
        //根据token Id查询登录信息 (user_login_token)
        UserLoginTokenVo userLoginTokenVo = appLoginService.findULTByTokenId(Long.valueOf(tokenId));
        return appSignOutService.signOut(userLoginTokenVo.getId());
    }
}
