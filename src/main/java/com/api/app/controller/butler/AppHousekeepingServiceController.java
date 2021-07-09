package com.api.app.controller.butler;

import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.model.app.AppHousekeepingService;
import com.api.model.app.SearchAppHousekeepingService;
import com.api.vo.app.AppFacilitiesAppointmentVo;
import com.api.vo.app.AppHousekeepingServiceVo;
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
 * app 新版家政服务
 */
@RestController
@RequestMapping("app/user/housekeepingService")
public class AppHousekeepingServiceController {
    @Resource
    AppHousekeepingServiceService appHousekeepingServiceService;

    /**
     * 确认提交家政
     * @param appHousekeepingService app 新版家政服务 model
     * @param request app-admin-token获取的request用户信息
     * @return map
     */
    @PostMapping("/submitHousekeeping")
    public Map<String,Object> submitHousekeeping(@RequestBody AppHousekeepingService appHousekeepingService, HttpServletRequest request){
        //从request获取用户id
        Integer id = Integer.valueOf(request.getParameter("id"));
        appHousekeepingService.setProposer(id);
        appHousekeepingService.setApplyTime(new Date());
        appHousekeepingService.setCreateId(id);
        appHousekeepingService.setCreateDate(new Date());
        return appHousekeepingServiceService.submitHousekeeping(appHousekeepingService);
    }

    /**
     * 查询所有的家政服务信息(包含条件搜索)
     * @param searchAppHousekeepingService app 新版家政服务搜素条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchAppHousekeepingService searchAppHousekeepingService){
        PageHelper.startPage(searchAppHousekeepingService.getPageNum(),searchAppHousekeepingService.getSize());
        List<AppHousekeepingServiceVo> appHousekeepingServiceVoList =appHousekeepingServiceService.list(searchAppHousekeepingService);
        PageInfo<AppHousekeepingServiceVo> pageInfo = new PageInfo<>(appHousekeepingServiceVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
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
