package com.api.manage.controller.businessManagement;

import com.api.manage.service.businessManagement.SysRPRecordsService;
import com.api.model.businessManagement.SearchRPRecords;
import com.api.model.businessManagement.SysRPRecords;
import com.api.vo.basicArchives.VoIds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 奖惩记录管理
 */
@RestController
@RequestMapping("manage/RPRecords")
public class SysRPRecordsController {
    @Resource
    SysRPRecordsService sysRPRecordsService;

    /**
     * 查询所有的奖惩记录
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchRPRecords searchRPRecords){
        PageHelper.startPage(searchRPRecords.getPageNum(),searchRPRecords.getSize());
        List<SysRPRecords> sysRPRecordsList = sysRPRecordsService.list(searchRPRecords);
        PageInfo<SysRPRecords> pageInfo = new PageInfo<>(sysRPRecordsList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加奖惩记录
     * @param sysRPRecords 奖惩记录model
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysRPRecords sysRPRecords){
        return sysRPRecordsService.insert(sysRPRecords);
    }

    /**
     * 批量删除奖惩记录
     * @param ids 奖惩记录主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysRPRecordsService.delete(ids.getIds());
    }
}
