package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerRepairEngineeringService;
import com.api.model.butlerApp.ButlerRepairEngineeringSearch;
import com.api.vo.butlerApp.ButlerRepairVo;
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
 * 管家app 报事报修工程维修
 */
@RestController
@RequestMapping("butlerApp/user/repairEngineering")
public class ButlerRepairEngineeringController {
    @Resource
    ButlerRepairEngineeringService butlerRepairEngineeringService;

    /**
     * 查询所有的报事报修工程维修信息（包含条件搜索）
     * @param butlerRepairEngineeringSearch 管家app 报事报修-工程维修 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerRepairEngineeringSearch butlerRepairEngineeringSearch){
        PageHelper.startPage(butlerRepairEngineeringSearch.getPageNum(),butlerRepairEngineeringSearch.getSize());
        List<ButlerRepairVo> butlerRepairVos =butlerRepairEngineeringService.list(butlerRepairEngineeringSearch);
        PageInfo<ButlerRepairVo> pageInfo = new PageInfo<>(butlerRepairVos);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


}
