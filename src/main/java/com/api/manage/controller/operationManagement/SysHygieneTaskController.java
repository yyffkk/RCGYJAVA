package com.api.manage.controller.operationManagement;

import com.api.manage.service.operationManagement.SysHygieneTaskService;
import com.api.model.operationManagement.SysHygieneTask;
import com.api.model.operationManagement.SearchHygieneTask;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.operationManagement.VoHygieneTask;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卫生任务管理
 */
@RestController
@RequestMapping("manage/hygieneTask")
public class SysHygieneTaskController {
    @Resource
    SysHygieneTaskService sysHygieneTaskService;

    /**
     * 查询所有的卫生任务信息(包含条件搜索)
     * @param searchHygieneTask 卫生任务搜索条件
     * @return map
     */
    @GetMapping("/list")
    public Map<String,Object> list(SearchHygieneTask searchHygieneTask){
        PageHelper.startPage(searchHygieneTask.getPageNum(),searchHygieneTask.getSize());
        List<VoHygieneTask> voHygieneTaskList = sysHygieneTaskService.list(searchHygieneTask);
        PageInfo<VoHygieneTask> pageInfo = new PageInfo<>(voHygieneTaskList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加卫生任务信息
     * @param sysHygieneTask 卫生任务model信息
     * @return map
     */
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody SysHygieneTask sysHygieneTask){
        return sysHygieneTaskService.insert(sysHygieneTask);
    }

    /**
     * 根据卫生任务主键id 查询卫生任务信息
     * @param id 卫生任务主键id
     * @return map
     */
    @GetMapping("/findById")
    public Map<String,Object> findById(Integer id){
        return sysHygieneTaskService.findById(id);
    }

    /**
     * 批量删除卫生任务信息
     * @param ids 卫生任务主键id数组
     * @return map
     */
    @PostMapping("/delete")
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysHygieneTaskService.delete(ids.getIds());
    }
}
