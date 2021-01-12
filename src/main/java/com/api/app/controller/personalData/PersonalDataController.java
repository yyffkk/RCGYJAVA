package com.api.app.controller.personalData;

import com.api.app.service.personalData.PersonalDataService;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.PersonalDataVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人资料
 */
@RestController
@RequestMapping("app/user/personalData")
public class PersonalDataController {
    @Resource
    PersonalDataService personalDataService;


    /**
     * 获取用户信息
     * @param userResident 住户信息表
     * @return map
     */
    @GetMapping("/getUserDetail")
    public Map<String, Object> getUserDetail(UserResident userResident){
        Map<String, Object> map = new HashMap<>();
        map.put("status", true);
        map.put("message", "请求成功");
        map.put("data", userResident);
        return map;
    }

    /**
     * 查询个人资料信息
     * @param userResident 住户信息表
     * @return map
     */
    @GetMapping("/findPersonalData")
    public Map<String,Object> findPersonalData(UserResident userResident){
        Map<String, Object> map = new HashMap<>();
        PersonalDataVo byId = personalDataService.findById(userResident.getId());
        map.put("status", true);
        map.put("message", "请求成功");
        map.put("data", byId);
        return map;
    }


    /**
     * 修改用户昵称
     * @param userResident 住户信息表
     * @param updateNickName 用户需要修改的昵称
     * @return map
     */
    @GetMapping("/updateNickName")
    public Map<String,Object> updateNickName(UserResident userResident,String updateNickName){
        //填入需要修改的昵称
        userResident.setNickName(updateNickName);
        return personalDataService.updateNickName(userResident);
    }

    /**
     * 修改头像
     * @param userResident 住户信息表
     * @param imgUrl 头像资源路径
     * @return map
     */
    @GetMapping("/updateHeadPortrait")
    public Map<String,Object> updateHeadPortrait(UserResident userResident,String imgUrl){
//        new
        return null;
    }








}
