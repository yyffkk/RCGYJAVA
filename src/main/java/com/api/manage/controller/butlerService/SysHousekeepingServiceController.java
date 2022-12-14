package com.api.manage.controller.butlerService;

import com.api.app.service.butler.AppHousekeepingServiceService;
import com.api.manage.service.butlerService.SysHousekeepingServiceService;
import com.api.model.butlerService.SearchHousekeepingService;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.butlerService.VoHousekeeping;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新版家政服务管理
 */
@RestController
@RequestMapping("manage/housekeepingService")
public class SysHousekeepingServiceController {
    @Resource
    SysHousekeepingServiceService sysHousekeepingServiceService;

    @Resource
    AppHousekeepingServiceService appHousekeepingServiceService;

    /**
     * 查询所有的家政服务信息（包含条件搜索）
     * @param searchHousekeepingService 家政服务搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchHousekeepingService searchHousekeepingService){
        PageHelper.startPage(searchHousekeepingService.getPageNum(),searchHousekeepingService.getSize());
        List<AppHousekeepingServiceVo> appHousekeepingServiceVoList = sysHousekeepingServiceService.list(searchHousekeepingService);
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

    /**
     * 作废
     * @param housekeepingServiceId 家政服务主键id
     * @return map
     */
    @GetMapping("/invalid")
    public Map<String,Object> invalid(Integer housekeepingServiceId){
        return sysHousekeepingServiceService.invalid(housekeepingServiceId);
    }
}
