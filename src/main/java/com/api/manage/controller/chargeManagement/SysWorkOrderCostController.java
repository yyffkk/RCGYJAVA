package com.api.manage.controller.chargeManagement;


import com.api.model.chargeManagement.SearchDailyPayment;
import com.api.manage.service.chargeManagement.SysWorkOrderCostService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.chargeManagement.VoWorkOrderCost;
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
 * 工单费用
 */
@RestController
@RequestMapping("manage/workOrderCost")
public class SysWorkOrderCostController   {
    @Resource
    SysWorkOrderCostService sysWorkOrderCostService;

    /**
     * 查询所有的工单费用信息 （包含条件搜索）
     * @param searchDailyPayment 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0401","04"},logical = Logical.AND)
    public Map<String,Object> list(SearchDailyPayment searchDailyPayment){
        PageHelper.startPage(searchDailyPayment.getPageNum(),searchDailyPayment.getSize());
        List<VoWorkOrderCost> voWorkOrderCostList = sysWorkOrderCostService.list(searchDailyPayment);
        PageInfo<VoWorkOrderCost> pageInfo = new PageInfo<>(voWorkOrderCostList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 批量假删除缴费信息
     * @param ids 缴费主键id 数组
     * @return map
     */
    @PostMapping("/falseDelete")
    @RequiresPermissions(value = {"0404","04"},logical = Logical.AND)
    public Map<String,Object> falseDelete(@RequestBody VoIds ids){
        return sysWorkOrderCostService.falseDelete(ids.getIds());
    }


}
