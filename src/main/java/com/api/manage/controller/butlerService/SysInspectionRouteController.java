package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysInspectionRouteService;
import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionRoute;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoBorrow;
import com.api.vo.butlerService.VoInspectionRoute;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡检路线管理
 */
@RestController
@RequestMapping("manage/inspectionRoute")
public class SysInspectionRouteController {
    @Resource
    SysInspectionRouteService sysInspectionRouteService;

    /**
     * 查询所有的巡检路线信息（包含条件搜索）
     * @param searchInspectionPoint 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301","03"},logical = Logical.AND)
    public Map<String,Object> list(SearchInspectionPoint searchInspectionPoint){
        PageHelper.startPage(searchInspectionPoint.getPageNum(),searchInspectionPoint.getSize());
        List<VoInspectionRoute> voInspectionRouteList = sysInspectionRouteService.list(searchInspectionPoint);
        PageInfo<VoInspectionRoute> pageInfo = new PageInfo<>(voInspectionRouteList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加巡检路线信息
     * @param sysInspectionRoute 巡检路线model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303","03"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysInspectionRoute sysInspectionRoute){
        return sysInspectionRouteService.insert(sysInspectionRoute);
    }

    /**
     * 根据巡检路线主键id查询巡检路线信息
     * @param id 巡检路线主键id
     * @return map
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> findById(Integer id){
        return sysInspectionRouteService.findById(id);
    }

    /**
     * 修改巡检路线信息
     * @param sysInspectionRoute 巡检路线model
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305","03"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysInspectionRoute sysInspectionRoute){
        return sysInspectionRouteService.update(sysInspectionRoute);
    }

    /**
     * 假删除巡检路线信息
     * @param voIds 巡检路线主键数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0304","03"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds voIds){
        return sysInspectionRouteService.falseDelete(voIds.getIds());
    }

    /**
     * 启用/停用巡检路线
     * @param id 巡检路线主键id
     * @return map
     */
    @GetMapping("/isEnable")
    @RequiresPermissions(value = {"0315","03"},logical = Logical.AND)
    public Map<String,Object> isEnable(Integer id){
        return sysInspectionRouteService.isEnable(id);
    }



}
