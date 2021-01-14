package com.api.app.controller.login;

import com.api.app.service.login.AppLoginService;
import com.api.manage.service.basicArchives.CpmBuildingService;
import com.api.manage.service.basicArchives.CpmBuildingUnitEstateService;
import com.api.model.app.UserCode;
import com.api.model.app.UserRegister;
import com.api.vo.basicArchives.VoFindAll;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/login")
public class AppLoginController {
    @Resource
    AppLoginService appLoginService;
    @Resource
    CpmBuildingService cpmBuildingService;
    @Resource
    CpmBuildingUnitEstateService cpmBuildingUnitEstateService;

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
     * @param userRegister 用户注册信息
     * @return map
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody UserRegister userRegister){
        return appLoginService.register(userRegister);
    }

    /**
     * 查询所有楼栋id和name
     * @return List<VoFindAll>
     */
    @GetMapping("/findAllBuildingIAN")
    public Map<String,Object> findAllBuildingIAN(){
        Map<String,Object> map = new HashMap<>();
        List<VoFindAll> all = cpmBuildingService.findAll();
        map.put("message","请求成功");
        map.put("data",all);
        map.put("status",true);
        return map;
    }

    /**
     * 根据楼栋id查询对应的楼栋单元房产id和name
     * @param buildingId 楼栋id
     * @return List<VoFindAll>
     */
    @GetMapping("/findEstateIANByBuilding")
    public Map<String,Object> findEstateIANByBuilding(Integer buildingId){
        Map<String,Object> map = new HashMap<>();
        List<VoFindAll> byBuildingId = cpmBuildingUnitEstateService.findByBuildingId(buildingId);
        map.put("message","请求成功");
        map.put("data",byBuildingId);
        map.put("status",true);
        return map;
    }

}
