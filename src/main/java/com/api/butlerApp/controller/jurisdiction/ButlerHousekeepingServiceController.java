package com.api.butlerApp.controller.jurisdiction;

import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.butlerApp.service.jurisdiction.ButlerHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.butlerApp.ButlerGreenVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 新版家政服务（有权限分配版）
 */
@RestController
@RequestMapping("butlerApp/user/housekeepingService")
public class ButlerHousekeepingServiceController {
    @Resource
    ButlerHousekeepingServiceService butlerHousekeepingServiceService;
    @Resource
    AppHousekeepingServiceService appHousekeepingServiceService;


    /**
     * 查询所有的家政服务信息（包含搜索条件）
     * @param butlerHousekeepingServiceSearch 管家app  新版家政服务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch){
        //查询用户所属权限,type:1.派单人 2.接单人 3.没有权限
        int type = butlerHousekeepingServiceService.findJurisdictionByUserId(butlerHousekeepingServiceSearch.getRoleId());
        //分页查询信息
        PageHelper.startPage(butlerHousekeepingServiceSearch.getPageNum(),butlerHousekeepingServiceSearch.getSize());
        List<AppHousekeepingServiceVo> appHousekeepingServiceVoList =butlerHousekeepingServiceService.list(butlerHousekeepingServiceSearch,type);
        PageInfo<AppHousekeepingServiceVo> pageInfo = new PageInfo<>(appHousekeepingServiceVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 查询所有的接单人员
     * @return map
     */
    @GetMapping("/findPickUpSinglePersonnel")
    public Map<String,Object> findPickUpSinglePersonnel(){
        //12.环境卫生部
        int organizationId = 12;
        return butlerHousekeepingServiceService.findPickUpSinglePersonnel(organizationId);
    }

    /**
     * 派单
     * @param appHousekeepingService app 新版家政服务 model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/sendSingle")
    public Map<String,Object> sendSingle(@RequestBody AppHousekeepingService appHousekeepingService, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        //从request获取用户拥有的角色id
        String roleId = request.getParameter("roleId");
        appHousekeepingService.setAssigner(id);//填入分配人id
        appHousekeepingService.setAllocateTime(new Date());
        return butlerHousekeepingServiceService.sendSingle(appHousekeepingService,roleId);
    }

    /**
     * 接单
     * @param appHousekeepingService app 新版家政服务 model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/orderReceiving")
    public Map<String,Object> orderReceiving(@RequestBody AppHousekeepingService appHousekeepingService, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerHousekeepingServiceService.orderReceiving(appHousekeepingService,id);
    }


    /**
     * 提交报告
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/submitReport")
    public Map<String,Object> submitReport(@RequestBody AppHousekeepingService appHousekeepingService, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerHousekeepingServiceService.submitReport(appHousekeepingService,id);
    }

    /**
     * 催促人员
     * @param housekeepingServiceId 家政服务主键id
     * @param id 角色主键id
     * @return map
     */
    @GetMapping("/urgedWorkers")
    public Map<String,Object> urgedWorkers(Integer housekeepingServiceId,Integer id){
        return butlerHousekeepingServiceService.urgedWorkers(housekeepingServiceId,id);
    }

    /**
     * 根据家政服务主键id查询家政服务服务进程
     * @param housekeepingServiceId 家政服务主键id
     * @return 家政服务服务进程 3007663862
     */
    @GetMapping("/findHousekeepingProcessRecord")
    public Map<String,Object> findHousekeepingProcessRecord(Integer housekeepingServiceId){
        return appHousekeepingServiceService.findHousekeepingProcessRecord(housekeepingServiceId);
    }


}
