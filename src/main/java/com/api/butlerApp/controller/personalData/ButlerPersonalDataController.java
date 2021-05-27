package com.api.butlerApp.controller.personalData;

import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.personalData.ButlerPersonalDataService;
import com.api.manage.service.basicArchives.CpmBuildingService;
import com.api.manage.service.basicArchives.CpmBuildingUnitEstateService;
import com.api.manage.service.basicArchives.CpmBuildingUnitService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerUpdateHeadPortrait;
import com.api.model.butlerApp.ButlerUpdateTel;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.butlerApp.ButlerPersonalDataVo;
import com.api.vo.butlerApp.ButlerUserDetailVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("butlerApp/user/personalData")
public class ButlerPersonalDataController {
    @Resource
    ButlerPersonalDataService butlerPersonalDataService;
    @Resource
    ButlerRepairDao butlerRepairDao;
    @Resource
    CpmBuildingService cpmBuildingService;
    @Resource
    CpmBuildingUnitService cpmBuildingUnitService;
    @Resource
    CpmBuildingUnitEstateService cpmBuildingUnitEstateService;

    /**
     * 获取用户信息
     * @param sysUser 管家app用户信息
     * @return map
     */
    @GetMapping("/getUserDetail")
    public Map<String, Object> getUserDetail(SysUser sysUser){
        Map<String, Object> map = new HashMap<>();
        ButlerUserDetailVo butlerUserDetailVo = new ButlerUserDetailVo();
        butlerUserDetailVo.setId(sysUser.getId());
        butlerUserDetailVo.setNickName(sysUser.getNickName());
        butlerUserDetailVo.setRoleId(sysUser.getRoleId());

        String[] split = sysUser.getRoleId().split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                butlerUserDetailVo.setJurisdiction(jurisdictionIds);
            }
        }

        map.put("status", true);
        map.put("message", "请求成功");
        map.put("data", butlerUserDetailVo);
        return map;
    }

    /**
     * 查询个人资料信息
     * @param sysUser 系统用户信息表
     * @return map
     */
    @GetMapping("/findPersonalData")
    public Map<String,Object> findPersonalData(SysUser sysUser){
        Map<String, Object> map = new HashMap<>();
        ButlerPersonalDataVo byId = butlerPersonalDataService.findById(sysUser.getId());
        map.put("status", true);
        map.put("message", "请求成功");
        map.put("data", byId);
        return map;
    }

    /**
     * 修改管家用户昵称
     * @param sysUser 系统用户信息表
     * @param request butlerApp-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateNickName")
    public Map<String,Object> updateNickName(@RequestBody SysUser sysUser, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //填入用户id
        sysUser.setId(id);
        return butlerPersonalDataService.updateNickName(sysUser);
    }

    /**
     * 修改管家用户头像
     * @param butlerUpdateHeadPortrait 管家app修改头像信息资源
     * @param request butlerApp-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateHeadPortrait")
    public Map<String,Object> updateHeadPortrait(@RequestBody ButlerUpdateHeadPortrait butlerUpdateHeadPortrait, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerPersonalDataService.updateHeadPortrait(id,butlerUpdateHeadPortrait.getFileUrls());
    }

    /**
     * 发送手机号修改验证码
     * @param butlerUpdateTel 管家app修改手机号信息
     * @param request butlerApp-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("sendTelUpdateCode")
    public Map<String,Object> sendTelUpdateCode(@RequestBody ButlerUpdateTel butlerUpdateTel, HttpServletRequest request){
        //从request获取用户tel
        String oldTel = request.getParameter("tel");
        butlerUpdateTel.setOldTel(oldTel);
        return butlerPersonalDataService.sendTelUpdateCode(butlerUpdateTel);
    }

    /**
     * 根据新手机号发送修改验证码
     * @param butlerUpdateTel 管家app修改手机号信息
     * @param request butlerApp-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/updateTel")
    public Map<String,Object> updateTel(@RequestBody ButlerUpdateTel butlerUpdateTel, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户tel
        String oldTel = request.getParameter("tel");
        //填入用户id
        butlerUpdateTel.setId(id);
        return butlerPersonalDataService.updateTel(butlerUpdateTel,oldTel);
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
