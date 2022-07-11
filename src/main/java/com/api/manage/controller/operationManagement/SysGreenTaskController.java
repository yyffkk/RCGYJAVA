package com.api.manage.controller.operationManagement;


import com.api.manage.service.operationManagement.SysGreenTaskService;

import com.api.model.operationManagement.SearchGreenTask;
import com.api.model.operationManagement.SysGreenTask;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoGreenArea;
import com.api.vo.operationManagement.VoGreenTask;
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
 * 绿化任务管理
 */
@RestController
@RequestMapping("manage/greenTask")
public class SysGreenTaskController   {
    @Resource
    SysGreenTaskService sysGreenTaskService;

    /**
     * 查询所有的绿化任务（包含条件搜索）
     * @param searchGreenTask 搜索条件
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(SearchGreenTask searchGreenTask){
        PageHelper.startPage(searchGreenTask.getPageNum(),searchGreenTask.getSize());
        List<VoGreenTask> voGreenTaskList = sysGreenTaskService.list(searchGreenTask);
        PageInfo<VoGreenTask> pageInfo = new PageInfo<>(voGreenTaskList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加绿化任务信息
     * @param sysGreenTask 绿化任务model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysGreenTask sysGreenTask){
        return sysGreenTaskService.insert(sysGreenTask);
    }

    /**
     * 批量删除绿化任务信息
     * @param ids 绿化任务主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysGreenTaskService.delete(ids.getIds());
    }

    /**
     * 根据绿化任务主键id查询绿化任务检查报告信息
     * @param greenTaskId 绿化任务主键id
     * @return map
     */
    @GetMapping("/findCheckSituationByGreenTaskId")
    public Map<String,Object> findCheckSituationByGreenTaskId(Integer greenTaskId){
        return sysGreenTaskService.findCheckSituationByGreenTaskId(greenTaskId);
    }


}
