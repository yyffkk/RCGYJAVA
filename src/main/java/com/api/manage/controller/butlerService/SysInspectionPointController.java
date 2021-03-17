package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysInspectionPointService;
import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionPoint;
import com.api.vo.butlerService.VoBorrow;
import com.api.vo.butlerService.VoInspectionPoint;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡检点管理
 */
@RestController
@RequestMapping("manage/inspectionPoint")
public class SysInspectionPointController {
    @Resource
    SysInspectionPointService sysInspectionPointService;

    /**
     * 查询所有的巡检点信息（包含条件搜索）
     * @param searchInspectionPoint 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchInspectionPoint searchInspectionPoint){
        PageHelper.startPage(searchInspectionPoint.getPageNum(),searchInspectionPoint.getSize());
        List<VoInspectionPoint> voInspectionPoints = sysInspectionPointService.list(searchInspectionPoint);
        PageInfo<VoInspectionPoint> pageInfo = new PageInfo<>(voInspectionPoints);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加巡检点信息
     * @param sysInspectionPoint 巡检点model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysInspectionPoint sysInspectionPoint){
        return sysInspectionPointService.insert(sysInspectionPoint);
    }
}
