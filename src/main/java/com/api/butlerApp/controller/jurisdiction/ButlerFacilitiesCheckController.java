package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerFacilitiesCheckService;
import com.api.model.butlerApp.ButlerFacilitiesCheckSearch;
import com.api.model.butlerService.FacilitiesExecute;
import com.api.vo.butlerApp.ButlerFacilitiesCheckVo;
import com.api.vo.butlerApp.ButlerGreenVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管家app设施/设备检查
 */
@RestController
@RequestMapping("butlerApp/user/facilitiesCheck")
public class ButlerFacilitiesCheckController {
    @Resource
    ButlerFacilitiesCheckService butlerFacilitiesCheckService;

    /**
     * 查询所有的设施设备检查信息
     * @param butlerFacilitiesCheckSearch 管家app 设施设备检查搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerFacilitiesCheckSearch butlerFacilitiesCheckSearch){
        PageHelper.startPage(butlerFacilitiesCheckSearch.getPageNum(),butlerFacilitiesCheckSearch.getSize());
        List<ButlerFacilitiesCheckVo> butlerFacilitiesCheckVoList =butlerFacilitiesCheckService.list(butlerFacilitiesCheckSearch);
        PageInfo<ButlerFacilitiesCheckVo> pageInfo = new PageInfo<>(butlerFacilitiesCheckVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 提交报告
     * @param facilitiesExecute 设施/设备检查执行情况
     * @return map
     */
    @PostMapping("/submitCheck")
    public Map<String,Object> submitCheck(@RequestBody FacilitiesExecute facilitiesExecute){
        return butlerFacilitiesCheckService.submitCheck(facilitiesExecute);
    }
}
