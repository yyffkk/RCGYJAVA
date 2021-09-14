package com.api.manage.controller.butlerService;


import com.api.model.butlerService.ReportRepair;
import com.api.model.butlerService.SearchReportRepair;
import com.api.manage.service.butlerService.SysReportRepairService;
import com.api.vo.butlerService.VoFindByIdRepair;
import com.api.vo.butlerService.VoRepair;
import com.api.vo.butlerService.VoReportRepair;
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
 * 报事报修表
 */
@RestController
@RequestMapping("manage/reportRepair")
public class SysReportRepairController   {
    @Resource
    SysReportRepairService sysReportRepairService;

    /**
     * 查询所有报事报修信息（包含条件搜索）
     * @param searchReportRepair 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchReportRepair searchReportRepair){
        PageHelper.startPage(searchReportRepair.getPageNum(),searchReportRepair.getSize());
        List<VoReportRepair> voReportRepairList = sysReportRepairService.list(searchReportRepair);
        PageInfo<VoReportRepair> pageInfo = new PageInfo<>(voReportRepairList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 查询报修详情(报事报修派单界面的报修详情内容，主界面报修详情 请查询 【工单管理：报修工单详情】)
     * @param id 工单主键id
     * @return 报修详情
     */
    @GetMapping("/findRepairDetail")
    @RequiresPermissions(value = {"0302"},logical = Logical.AND)
    public VoRepair findRepairDetail(Integer id){
        return sysReportRepairService.findRepairDetail(id);
    }

    /**
     * 添加报事报修信息
     * @param reportRepair 报事报修信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody ReportRepair reportRepair){
        return sysReportRepairService.insert(reportRepair);
    }

    /**
     * 根据报事报修主键id 查询报事报修信息
     * @param id 报事报修主键id
     * @return 报事报修 Vo findById 回显
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302"},logical = Logical.AND)
    public VoFindByIdRepair findById(Integer id){
        return sysReportRepairService.findById(id);
    }


    /**
     * 修改报事报修信息
     * @param reportRepair 报事报修model insert
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody ReportRepair reportRepair){
        return sysReportRepairService.update(reportRepair);
    }

}
