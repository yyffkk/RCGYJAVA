package com.api.manage.controller.butlerService;


import com.api.model.butlerService.SysWorkOrderTimeLimit;
import com.api.manage.service.butlerService.SysWorkOrderTimeLimitService;
import com.api.vo.basicArchives.VoIds;
import com.api.vo.butlerService.VoWorkOrderTimeLimit;
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
 * 工单时限管理表
 */
@RestController
@RequestMapping("manage/workOrderTimeLimit")
public class SysWorkOrderTimeLimitController   {
    @Resource
    SysWorkOrderTimeLimitService sysWorkOrderTimeLimitService;

    /**
     * 查询所有的工单时限管理信息
     * @param pageNum 当前页数
     * @param size 每页记录数
     * @return map
     */
    @GetMapping("/list")
    @RequiresPermissions(value = {"0301"},logical = Logical.AND)
    public Map<String,Object> list(int pageNum,int size){
        PageHelper.startPage(pageNum,size);
        List<VoWorkOrderTimeLimit> voWorkOrderTimeLimitList = sysWorkOrderTimeLimitService.list();
        PageInfo<VoWorkOrderTimeLimit> pageInfo = new PageInfo<>(voWorkOrderTimeLimitList);
        Map<String,Object> map = new HashMap<>();
        map.put("tableList",pageInfo.getList());
        map.put("rowCount",pageInfo.getTotal());
        map.put("pageCount",pageInfo.getPages());
        return map;
    }

    /**
     * 添加工单时限信息
     * @param sysWorkOrderTimeLimit 工单时限信息
     * @return map
     */
    @PostMapping("/insert")
    @RequiresPermissions(value = {"0303"},logical = Logical.AND)
    public Map<String,Object> insert(@RequestBody SysWorkOrderTimeLimit sysWorkOrderTimeLimit){
        return sysWorkOrderTimeLimitService.insert(sysWorkOrderTimeLimit);
    }

    /**
     * 根据工单时限主键id查询工单时限信息
     * @param id 工单时限主键id
     * @return 工单时限信息
     */
    @GetMapping("/findById")
    @RequiresPermissions(value = {"0302"},logical = Logical.AND)
    public VoWorkOrderTimeLimit findById(Integer id){
        return sysWorkOrderTimeLimitService.findById(id);
    }

    /**
     * 更新工单时限信息
     * @param sysWorkOrderTimeLimit 新工单时限信息
     * @return map
     */
    @PostMapping("/update")
    @RequiresPermissions(value = {"0305"},logical = Logical.AND)
    public Map<String,Object> update(@RequestBody SysWorkOrderTimeLimit sysWorkOrderTimeLimit){
        return sysWorkOrderTimeLimitService.update(sysWorkOrderTimeLimit);
    }

    /**
     * 批量删除工单时限信息
     * @param ids 工单时限主键id数组
     * @return map
     */
    @PostMapping("/delete")
    @RequiresPermissions(value = {"0304"},logical = Logical.AND)
    public Map<String,Object> delete(@RequestBody VoIds ids){
        return sysWorkOrderTimeLimitService.delete(ids.getIds());
    }

}
