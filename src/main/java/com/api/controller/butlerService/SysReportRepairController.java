package com.api.controller.butlerService;

import com.api.model.butlerService.ReportRepair;
import com.api.model.butlerService.SearchReportRepair;
import com.api.service.butlerService.SysReportRepairService;
import com.api.vo.butlerService.VoBorrow;
import com.api.vo.butlerService.VoReportRepair;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报事报修表
 */
@RestController
@RequestMapping("reportRepair")
public class SysReportRepairController {
    @Resource
    SysReportRepairService sysReportRepairService;

    /**
     * 查询所有报事报修信息（包含条件搜索）
     * @param searchReportRepair 搜索条件
     * @return map
     */
    @GetMapping("/list")
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
     * 添加报事报修信息（原型图有问题）
     * @param reportRepair 报事报修信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(ReportRepair reportRepair){
        return null;
    }



}
