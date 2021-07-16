package com.api.butlerApp.controller.jurisdiction;

import com.api.butlerApp.service.jurisdiction.ButlerHousekeepingServiceService;
import com.api.model.butlerApp.ButlerHousekeepingServiceSearch;
import com.api.vo.app.AppHousekeepingServiceVo;
import com.api.vo.butlerApp.ButlerGreenVo;
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
 * 管家app 新版家政服务（有权限分配版）
 */
@RestController
@RequestMapping("butlerApp/user/housekeepingService")
public class ButlerHousekeepingServiceController {
    @Resource
    ButlerHousekeepingServiceService butlerHousekeepingServiceService;


    /**
     * 查询所有的家政服务信息（包含搜索条件）
     * @param butlerHousekeepingServiceSearch 管家app  新版家政服务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(ButlerHousekeepingServiceSearch butlerHousekeepingServiceSearch){
        PageHelper.startPage(butlerHousekeepingServiceSearch.getPageNum(),butlerHousekeepingServiceSearch.getSize());
        List<AppHousekeepingServiceVo> appHousekeepingServiceVoList =butlerHousekeepingServiceService.list(butlerHousekeepingServiceSearch);
        PageInfo<AppHousekeepingServiceVo> pageInfo = new PageInfo<>(appHousekeepingServiceVoList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

}
