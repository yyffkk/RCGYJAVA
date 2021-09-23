package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysFacilitiesPlanService;
import com.api.model.butlerService.FacilitiesPlan;
import com.api.model.butlerService.SearchFacilitiesExecute;
import com.api.model.butlerService.SearchFacilitiesPlan;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoFacilitiesExecute;
import com.api.vo.butlerService.VoFacilitiesPlan;
import com.api.vo.butlerService.VoGambit;
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
 * 设施设备检查计划管理
 */
@RestController
@RequestMapping("manage/facilitiesPlan")
public class SysFacilitiesPlanController {
    @Resource
    SysFacilitiesPlanService sysFacilitiesPlanService;

    /**
     * 查询所有的设施设备检查计划
     * @param searchFacilitiesPlan 设施设备检查计划搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchFacilitiesPlan searchFacilitiesPlan){
        PageHelper.startPage(searchFacilitiesPlan.getPageNum(),searchFacilitiesPlan.getSize());
        List<VoFacilitiesPlan> voFacilitiesPlanList = sysFacilitiesPlanService.list(searchFacilitiesPlan);
        PageInfo<VoFacilitiesPlan> pageInfo = new PageInfo<>(voFacilitiesPlanList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加设备/设施检查计划
     * @param facilitiesPlan 设施/设备检查计划model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody FacilitiesPlan facilitiesPlan){
        return sysFacilitiesPlanService.insert(facilitiesPlan);
    }

    /**
     * 批量删除设施/设备检查计划
     * @param ids 设施/设备检查计划主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysFacilitiesPlanService.delete(ids.getIds());
    }

    /**
     * 批量停用设施/设备检查计划
     * @param ids 设施/设备检查计划主键id数组
     * @return map
     */
    @PostMapping("/stop")
    public Map<String,Object> stop(@RequestBody VoIds ids){
        return sysFacilitiesPlanService.stop(ids.getIds());
    }

    /**
     * 批量开启设施/设备检查计划
     * @param ids 设施/设备检查计划主键id数组
     * @return map
     */
    @PostMapping("/open")
    public Map<String,Object> open(@RequestBody VoIds ids){
        return sysFacilitiesPlanService.open(ids.getIds());
    }

    /**
     * 查询所有的设施设备检查记录
     * @param searchFacilitiesExecute 设备/设施检查记录搜索条件
     * @return map
     */
    @GetMapping("/executeList")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> executeList(SearchFacilitiesExecute searchFacilitiesExecute){
        PageHelper.startPage(searchFacilitiesExecute.getPageNum(),searchFacilitiesExecute.getSize());
        List<VoFacilitiesExecute> voFacilitiesExecuteList = sysFacilitiesPlanService.executeList(searchFacilitiesExecute);
        PageInfo<VoFacilitiesExecute> pageInfo = new PageInfo<>(voFacilitiesExecuteList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
