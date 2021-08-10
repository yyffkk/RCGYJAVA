package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysRepairEngineeringService;
import com.api.model.butlerService.SearchRepairEngineering;
import com.api.vo.butlerService.VoRepairEngineering;
import com.api.vo.butlerService.VoReportRepair;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


}
