package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysStationChangeService;
import com.api.model.businessManagement.SearchStationChange;
import com.api.model.businessManagement.SysRPRecords;
import com.api.model.businessManagement.SysStationChange;
import com.api.vo.basicArchives.VoIds;
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
 * 岗位变动管理
 */
@RestController
@RequestMapping("manage/stationChange")
public class SysStationChangeController {
    @Resource
    SysStationChangeService sysStationChangeService;

    /**
     * 查询所有的岗位变动信息
     * @param searchStationChange 岗位变动 搜素条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0101"},logical = Logical.AND)
    public Map<String,Object> list(SearchStationChange searchStationChange){
        PageHelper.startPage(searchStationChange.getPageNum(),searchStationChange.getSize());
        List<SysStationChange> sysStationChangeList = sysStationChangeService.list(searchStationChange);
        PageInfo<SysStationChange> pageInfo = new PageInfo<>(sysStationChangeList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }


    /**
     * 添加岗位变动信息
     * @param sysStationChange 岗位变动model
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0104"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysStationChange sysStationChange){
        return sysStationChangeService.insert(sysStationChange);
    }

    /**
     * 批量删除岗位变动信息
     * @param ids 岗位变动信息主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysStationChangeService.delete(ids.getIds());
    }
}
