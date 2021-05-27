package com.api.app.controller.personalData;

import com.api.app.service.personalData.PersonalDataService;
import com.api.manage.service.basicArchives.CpmBuildingService;
import com.api.manage.service.basicArchives.CpmBuildingUnitEstateService;
import com.api.manage.service.basicArchives.CpmBuildingUnitService;
import com.api.model.app.AppUserInfo;
import com.api.model.app.PersonalData;
import com.api.model.app.UpdateHeadPortrait;
import com.api.model.app.UpdateTel;
import com.api.model.basicArchives.UserResident;
import com.api.vo.app.PersonalDataVo;
import com.api.vo.basicArchives.VoFindAll;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人资料
 */
@RestController
@RequestMapping("app/user/personalData")
public class PersonalDataController {
    @Resource
    PersonalDataService personalDataService;
    @Resource
    CpmBuildingService cpmBuildingService;
    @Resource
    CpmBuildingUnitService cpmBuildingUnitService;
    @Resource
    CpmBuildingUnitEstateService cpmBuildingUnitEstateService;

    /**
     * 获取用户信息
     * @param appUserInfo app用户信息
     * @return map
     */
    @GetMapping("/getUserDetail")
    public Map<String, Object> getUserDetail(AppUserInfo appUserInfo){
        Map<String, Object> map = new HashMap<>();
        //根据用户id查询房产信息
        List<String> stringList = personalDataService.findEstateNameByResidentId(appUserInfo.getId());
        appUserInfo.setEstateNames(stringList);
        map.put("status", true);
        map.put("message", "请求成功");
        map.put("data", appUserInfo);
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
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateNickName")
    public Map<String,Object> updateNickName(@RequestBody UserResident userResident,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入用户id
        userResident.setId(id);
        return personalDataService.updateNickName(userResident);
    }

    /**
     * 修改用户头像
     * @param updateHeadPortrait 修改头像信息资源
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateHeadPortrait")
    public Map<String,Object> updateHeadPortrait(@RequestBody UpdateHeadPortrait updateHeadPortrait,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return personalDataService.updateHeadPortrait(id,updateHeadPortrait.getFileUrls());
    }

    /**
     * 发送手机号修改验证码
     * @param updateTel 修改手机号信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("sendTelUpdateCode")
    public Map<String,Object> sendTelUpdateCode(@RequestBody UpdateTel updateTel,HttpServletRequest request){
        //从request获取用户tel
        String oldTel = request.getParameter("tel");
        updateTel.setOldTel(oldTel);
        return personalDataService.sendTelUpdateCode(updateTel);
    }

    /**
     * 根据新手机号发送修改验证码
     * @param updateTel 修改手机号信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateTel")
    public Map<String,Object> updateTel(@RequestBody UpdateTel updateTel, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户tel
        String oldTel = request.getParameter("tel");
        //填入用户id
        updateTel.setId(id);
        return personalDataService.updateTel(updateTel,oldTel);
    }


    /**
     * 修改用户性别
     * @param personalData 个人资料信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateSex")
    public Map<String,Object> updateSex(@RequestBody PersonalData personalData,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入用户id
        personalData.setId(id);
        return personalDataService.updateSex(personalData);
    }

    /**
     * 修改用户出生日期
     * @param personalData 个人资料信息
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateBirthday")
    public Map<String,Object> updateBirthday(@RequestBody PersonalData personalData,HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入用户id
        personalData.setId(id);
        return personalDataService.updateBirthday(personalData);
    }



    /**
     * 查询所有楼栋id和name(管家app)
     * @return List<VoFindAll>
     */
    @GetMapping("/findAll")
    public List<VoFindAll> findAll(){
        return cpmBuildingService.findAll();
    }

    /**
     * 根据楼栋id查询对应的单元id和name(管家app)
     * @param buildingId 楼栋id
     * @return List<VoFindAll>
     */
    @GetMapping("/findByBuildingId")
    public List<VoFindAll> findByBuildingId(Integer buildingId){
        return cpmBuildingUnitService.findByBuildingId(buildingId);
    }

    /**
     * 根据单元id查询对应的房产id和name(管家app)
     * @param unitId 楼栋单元id
     * @return List<VoFindAll>
     */
    @GetMapping("/findByBuildingUnitId")
    public List<VoFindAll> findByBuildingUnitId(Integer unitId){
        return cpmBuildingUnitEstateService.findByBuildingUnitId(unitId);
    }


}
