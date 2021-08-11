package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysRepairEngineeringService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerRepairEngineering;
import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineering;
import com.api.vo.butlerService.VoReportRepair;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报事报修 工程维修表
 */
@RestController
@RequestMapping("manage/repairEngineering")
public class SysRepairEngineeringController {
    @Resource
    SysRepairEngineeringService sysRepairEngineeringService;

    /**
     * 查询所有的工程维修信息
     * @param searchRepairEngineering 报事报修工程维修 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchRepairEngineering searchRepairEngineering){
        PageHelper.startPage(searchRepairEngineering.getPageNum(),searchRepairEngineering.getSize());
        List<VoRepairEngineering> voRepairEngineeringList = sysRepairEngineeringService.list(searchRepairEngineering);
        PageInfo<VoRepairEngineering> pageInfo = new PageInfo<>(voRepairEngineeringList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 根据工程维修主键id查询工程维修信息
     * @param repairEngineeringId 工程维修主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer repairEngineeringId){
        return sysRepairEngineeringService.findById(repairEngineeringId);
    }

    /**
     * 添加报事报修工程维修
     * @param butlerRepairEngineering 管家app 报事报修工程维修model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(ButlerRepairEngineering butlerRepairEngineering){
        return sysRepairEngineeringService.insert(butlerRepairEngineering);
    }



}
