package com.api.manage.controller.butlerService;

import com.api.manage.service.butlerService.SysHousekeepingService;
import com.api.model.butlerService.SearchHousekeeping;
import com.api.vo.butlerService.VoGambitTheme;
import com.api.vo.butlerService.VoHousekeeping;
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
 * 家政服务管理
 */
@RestController
@RequestMapping("manage/housekeeping")
public class SysHousekeepingController {
    @Resource
    SysHousekeepingService sysHousekeepingService;

    /**
     * 查询所有的家政服务信息
     * @param searchHousekeeping 家政服务 搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchHousekeeping searchHousekeeping){
        PageHelper.startPage(searchHousekeeping.getPageNum(),searchHousekeeping.getSize());
        List<VoHousekeeping> voHousekeepingList = sysHousekeepingService.list(searchHousekeeping);
        PageInfo<VoHousekeeping> pageInfo = new PageInfo<>(voHousekeepingList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }
}
