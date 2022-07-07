package com.api.butlerApp.controller.butler;


import com.api.butlerApp.service.butler.ButlerHousekeepingService;
import com.api.manage.service.basicArchives.CpmBuildingService;
import com.api.manage.service.basicArchives.CpmBuildingUnitEstateService;
import com.api.manage.service.basicArchives.CpmBuildingUnitService;
import com.api.model.butlerApp.ButlerHousekeeping;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.butlerApp.ButlerHousekeepingVo;
import com.api.vo.operationManagement.VoAttendanceRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app 家政管理(无权限分配版)
 */
@RestController
@RequestMapping("butlerApp/user/housekeeping")
public class ButlerHousekeepingController {
    @Resource
    ButlerHousekeepingService butlerHousekeepingService;

    /**
     * 查询所有的家政服务信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @param id 用户主键id
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(int pageNum,int size,Integer id){
        PageHelper.startPage(pageNum,size);
        List<ButlerHousekeepingVo> butlerHousekeepingVoList =butlerHousekeepingService.list(id);
        PageInfo<ButlerHousekeepingVo> pageInfo = new PageInfo<>(butlerHousekeepingVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加家政服务信息
     * @param butlerHousekeeping 管家app 家政服务model
     * @param request butlerApp-admin-token获取的request管家用户信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody ButlerHousekeeping butlerHousekeeping, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        return butlerHousekeepingService.insert(butlerHousekeeping,id);
    }
}
